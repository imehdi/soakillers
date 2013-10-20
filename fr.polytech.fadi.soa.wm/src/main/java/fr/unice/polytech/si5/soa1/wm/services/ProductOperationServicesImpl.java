package fr.unice.polytech.si5.soa1.wm.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import fr.unice.polytech.si5.soa1.wm.data.ProductFacade;
import fr.unice.polytech.si5.soa1.wm.data.ProductOperationFacade;
import fr.unice.polytech.si5.soa1.wm.model.ProductOperation;
import fr.unice.polytech.si5.soa1.wm.model.ProductOperationExceptions;

public class ProductOperationServicesImpl {

	String productsYAKLocation;
	String productsOperationsYAKLocation;

	ObjectContainer dbProducts;
	ObjectContainer dbProductsOperations;

	ProductFacade pF;
	ProductOperationFacade pOF;

	public ProductOperationServicesImpl() {

	}

	public void contextInitialized() {
		productsYAKLocation = "yak-data/products-yak-data.yak";
		productsOperationsYAKLocation = "yak-data/products-operations-yak-data.yak";

		dbProducts = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				productsYAKLocation);
		dbProductsOperations = Db4oEmbedded.openFile(
				Db4oEmbedded.newConfiguration(), productsOperationsYAKLocation);

		pF = new ProductFacade(dbProducts);
		pOF = new ProductOperationFacade(dbProductsOperations);
	}

	public void contextDestroyed() {
		dbProducts.close();
		dbProductsOperations.close();
	}

	public String performProductOperationFromJSON(JSONObject obj)
			throws JSONException, ProductOperationExceptions, ParseException {
		this.contextInitialized();

		ProductOperation oP = new ProductOperation(obj.getString("company"),
				pF.find((long) obj.getInt("productId")),
				Boolean.parseBoolean(obj.getString("consume")),
				obj.getInt("quantity"), obj.getString("orderDate"));
		pOF.create(oP);

		this.contextDestroyed();

		return oP.toJson();
	}

	public Response performProductOperationImpl(String json) {
		try {
			String jsonOut = this
					.performProductOperationFromJSON(new JSONObject(json));
			return Response.status(Status.OK).entity(jsonOut).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	public Response getProductsToDeliver(int numberOfDays) {
		this.contextInitialized();

		Calendar currentCal = Calendar.getInstance();
		Date currentDate = currentCal.getTime();

		// I did used numberOfDays + 1 because I'm using a range.
		currentCal.add(Calendar.DAY_OF_MONTH, ++numberOfDays);
		Date endOfWeekDeliveryDate = currentCal.getTime();

		// I will use this variable to check if there's orders to deliver.
		int checkFound = 0;
		int productsOrdersSize = pOF.findAll().size();

		String respBegin = "[\n";
		String resp = "";

		for (ProductOperation pO : pOF.findAll()) {
			productsOrdersSize--;
			if (pO.getOrderDate().after(currentDate)
					&& pO.getOrderDate().before(endOfWeekDeliveryDate)) {
				++checkFound;
				resp += "{ \"id\":\"" + pO.getId() + "\" , " + "\"to\":\""
						+ pO.getCompany() + "\" , " + "\"orderDate\":\""
						+ pO.getOrderDate() + "\" }";
				if (productsOrdersSize == 0) {
					resp += "\n";
				} else {
					resp += ", \n";
				}
			}
		}

		String respEnd = "]";
		String finalResp = respBegin + resp + respEnd;

		this.contextDestroyed();

		if (checkFound == 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.status(Status.OK).entity(finalResp).build();
		}
	}
}
