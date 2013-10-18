package fr.unice.polytech.si5.soa1.wm.services;

import java.text.ParseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import fr.unice.polytech.si5.soa1.wm.data.ProductFacade;
import fr.unice.polytech.si5.soa1.wm.model.Product;
import fr.unice.polytech.si5.soa1.wm.model.ProductOperationExceptions;

public class ProductServicesImpl {

	String productsYAKLocation;

	ObjectContainer dbProducts;

	ProductFacade pF;

	public ProductServicesImpl() {

	}

	public void contextInitialized() {
		productsYAKLocation = "yak-data/products-yak-data.yak";

		dbProducts = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
				productsYAKLocation);

		pF = new ProductFacade(dbProducts);
	}

	public void contextDestroyed() {
		dbProducts.close();
	}

	public String getProductsInformationsFromJSON(JSONObject obj)
			throws JSONException, ProductOperationExceptions, ParseException {
		
		this.contextInitialized();
		
		if (obj.getString("id").equals("*")) {
			JSONArray jsonProductsArray = new JSONArray();
			if (obj.getString("property").equals("*")) {
				for (Product p : pF.findAll()) {
					jsonProductsArray.put(new JSONObject(p.toJson()));
				}
				this.contextDestroyed();
				return jsonProductsArray.toString();
			} else {
				for (Product p : pF.findAll()) {
					JSONObject productJSON = new JSONObject(p.toJson());

					jsonProductsArray.put(new JSONObject("{ \"id\":\""
							+ productJSON.getString("id") + "\" , " + "\""
							+ obj.getString("property") + "\":\""
							+ productJSON.getString(obj.getString("property"))
							+ "\" }"));
				}
				this.contextDestroyed();
				return jsonProductsArray.toString();
			}
		} else {
			JSONObject productJSON = new JSONObject(pF.find(
					Long.parseLong(obj.getString("id"))).toJson());

			if (obj.getString("property").equals("*")) {
				this.contextDestroyed();
				return productJSON.toString();
			} else {
				this.contextDestroyed();
				return "{ \"id\":\"" + productJSON.getString("id") + "\" , "
						+ "\"" + obj.getString("property") + "\":\""
						+ productJSON.getString(obj.getString("property"))
						+ "\" }";
			}
		}
	}

	public Response getProductsInformationsImpl(String json) {
		try {
			String jsonOut = this
					.getProductsInformationsFromJSON(new JSONObject(json));
			return Response.status(Status.OK).entity(jsonOut).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	public Response getProductLocationImpl(Long productId) {
		try {
			this.contextDestroyed();
			Product p = pF.find(productId);
			this.contextDestroyed();
			return Response.status(Status.OK).entity(p.locationToJson())
					.build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	public Response getNearlyOutOfStockProducts() {
		this.contextDestroyed();
		int productsSize = pF.findAll().size();

		// I will use this variable to check if there are out of stock products.
		int checkFound = 0;

		String respBegin = "[\n";
		String resp = "";

		for (Product product : pF.findAll()) {
			productsSize--;
			if (product.getUnitsInStock() < 15) {
				++checkFound;
				resp += "{ \"id\":\"" + product.getId() + "\" , "
						+ "\"unitsInStock\":\"" + product.getUnitsInStock()
						+ "\" }";
				if (productsSize == 0) {
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