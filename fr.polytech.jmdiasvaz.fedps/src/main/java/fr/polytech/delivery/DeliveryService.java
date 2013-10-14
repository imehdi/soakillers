package fr.polytech.delivery;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("delivery")
public class DeliveryService {

	@POST
	@Produces("text/json")
	public Response orderDelivery(
			@QueryParam("pickUpAddress") String puAddress,
			@QueryParam("pickUpCity") String puCity,
			@QueryParam("deliveryAddress") String dAddress,
			@QueryParam("deliveryCity") String dCity,
			@QueryParam("packageLength") String plength,
			@QueryParam("packageWidth") String pwidth,
			@QueryParam("packageHeight") String pheight,
			@QueryParam("packageWeight") String pweight) {

		if (puAddress == null || puCity == null || dAddress == null
				|| dCity == null || plength == null || pwidth == null
				|| pheight == null || pweight == null) {
			return Response.status(Status.BAD_REQUEST).build();
		} else {
			 String resp = "{\"id\": \"0123456789\"}";
			return Response.status(Status.OK).entity(resp).build();
		}
	}

	@GET
	@Produces("text/json")
	@Path("{id}/quote")
	public Response buildQuote(@PathParam("id") String id) {
		if (!id.equals("0123456789"))
			return Response.status(Status.NOT_FOUND).build();
		else {
			String resp = "{\"day\" : \"01\", \"month\" : \"02\", \"year\" : \"2000\", \"hour\" : \"03\", \"min\" : \"04\", \"price\" : \"9000\"}";
			return Response.status(Status.OK).entity(resp).build();
		}
	}

	@GET
	@Produces("text/json")
	@Path("{id}/track")
	public Response trackDelivery(@PathParam("id") String id) {
		if (!id.equals("0123456789"))
			return Response.status(Status.NOT_FOUND).build();
		else {
			String resp = "{ \"address\" : \"930 route des Colles\", \"city\" : \"Sophia Antipolis\", \"day\" : \"04\", \"month\" : \"02\", \"year\" : \"2000\", \"hour\" : \"06\", \"min\" : \"04\"}";
			return Response.status(Status.OK).entity(resp).build();
		}
	}
}