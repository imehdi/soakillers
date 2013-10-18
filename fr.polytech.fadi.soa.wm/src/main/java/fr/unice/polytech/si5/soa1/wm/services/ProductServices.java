package fr.unice.polytech.si5.soa1.wm.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("product")
public class ProductServices {

	ProductServicesImpl pSI;
	ProductOperationServicesImpl pOSI;

	public ProductServices() {
		pSI = new ProductServicesImpl();
		pOSI = new ProductOperationServicesImpl();
	}

	// This method is used to perform an operation on a product (suppling,
	// pickups)
	@POST
	@Path("/po/")
	@Consumes("text/json")
	@Produces("text/json")
	public Response performProductOperation(String json) {
		return pOSI.performProductOperationImpl(json);
	}

	// This method return all the informations of a given product id.
	@POST
	@Path("/pinfo/")
	@Consumes("text/json")
	@Produces("text/json")
	public Response getProductsInformations(String json) {
		return pSI.getProductsInformationsImpl(json);
	}

	// This method return the location of a given product id.
	@GET
	@Path("/location/{productId}")
	@Produces("text/json")
	public Response getProductLocation(@PathParam("productId") Long productId) {
		return pSI.getProductLocationImpl(productId);
	}

	// This method return the out of stock products.
	@GET
	@Path("/nearlyoutofstock/")
	@Produces("text/json")
	public Response getNearlyOutOfStockProducts() {
		return pSI.getNearlyOutOfStockProducts();
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
		return pOSI.getProductsToDeliver(numberOfDays);
	}
}
