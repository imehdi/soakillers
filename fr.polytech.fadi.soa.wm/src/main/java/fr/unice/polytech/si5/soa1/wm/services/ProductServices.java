package fr.unice.polytech.si5.soa1.wm.services;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.*;

import fr.unice.polytech.si5.soa1.wm.*;
import fr.unice.polytech.si5.soa1.wm.initialize.InitializeData;

@Path("product")
public class ProductServices {

	private static InitializeData iD = new InitializeData();;

	public ProductServices() {
	}

	// This method is used to perform an operation on a product (suppling, pickups)
	@POST
	@Path("/po/")
	@Consumes("text/json")
	@Produces("text/json")
	public Response performProductOperation(String json) {
		try {
            ProductOperation oP = iD.performProductOperationFromJSON(new JSONObject(json));
			return Response.status(Status.OK).entity(oP.toJson()).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	// This method return all the informations of a given product id.
	@GET
	@Path("/info/{productId}")
	@Produces("text/json")
	public Response getProductInformations(
			@PathParam("productId") Long productId) {
		try {
			Product p = new Product();
			p = iD.getProductById(productId);
			return Response.status(Status.OK).entity(p.toJson()).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// This method return the amount of a given product id.
	@GET
	@Path("/amount/{productId}")
	@Produces("text/json")
	public Response getProductAmount(@PathParam("productId") Long productId) {
		try {
			Product p = iD.getProductById(productId);

			return Response.status(Status.OK).entity(p.amountToJson()).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// This method return the location of a given product id.
	@GET
	@Path("/location/{productId}")
	@Produces("text/json")
	public Response getProductLocation(@PathParam("productId") Long productId) {
		try {
			Product p = iD.getProductById(productId);
			return Response.status(Status.OK).entity(p.locationToJson()).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// This method return the out of stock products.
	@GET
	@Path("/nearlyoutofstock/")
	@Produces("text/json")
	public Response getNearlyOutOfStockProducts() {
		int productsSize = iD.getProducts().size();

		// I will use this variable to check if there are out of stock products.
		int checkFound = 0;

		String respBegin = "{\n\"products\": [\n";
		String resp = "";

		for (Product product : iD.getProducts()) {
			productsSize--;
			if (product.getUnitsInStock() < 15) {
				++checkFound;
				resp += "{ \"id\":\"" + product.getId() + "\" , "
						+ "\"unitsInStock\":\"" + product.getUnitsInStock() + "\" }";
				if (productsSize == 0) {
					resp += "\n";
				} else {
					resp += ", \n";
				}
			}
		}

		String respEnd = "]\n}";
		String finalResp = respBegin + resp + respEnd;

		if (checkFound == 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.status(Status.OK).entity(finalResp).build();
		}
	}

	/*
	 * This method return products to be delivered in a given number of days. If
	 * we want to get the products to be delivered next week, we will enter 7 as
	 * the number of days.
	 */
	@GET
	@Path("/deliveries/{numberOfDays}")
	@Produces("text/json")
	public Response getProductsToDeliver(
		@PathParam("numberOfDays") int numberOfDays) {
		Calendar currentCal = Calendar.getInstance();
		Date currentDate = currentCal.getTime();

		// I did used numberOfDays + 1 because I'm using a range.
		currentCal.add(Calendar.DAY_OF_MONTH, ++numberOfDays);
		Date endOfWeekDeliveryDate = currentCal.getTime();

		// I will use this variable to check if there's orders to deliver.
		int checkFound = 0;
		int productsOrdersSize = iD.getProductsOperations().size();

		String respBegin = "{\n\"products\": [\n";
		String resp = "";

		for (ProductOperation pO : iD.getProductsOperations()) {
			productsOrdersSize--;
			if (pO.getOrderDate().after(currentDate)
					&& pO.getOrderDate().before(endOfWeekDeliveryDate)) {
				++checkFound;
				resp += "{ \"id\":\"" + pO.getId() + "\" , "
						+ "\"to\":\"" + pO.getCompany() + "\" , "
						+ "\"orderDate\":\"" + pO.getOrderDate() + "\" }";
				if (productsOrdersSize == 0) {
					resp += "\n";
				} else {
					resp += ", \n";
				}
			}
		}

		String respEnd = "]\n}";
		String finalResp = respBegin + resp + respEnd;

		if (checkFound == 0) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.status(Status.OK).entity(finalResp).build();
		}
	}
}