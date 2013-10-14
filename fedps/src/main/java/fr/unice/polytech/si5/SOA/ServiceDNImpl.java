package fr.unice.polytech.si5.SOA;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

public class ServiceDNImpl implements ServiceDN {

	@Override
	@WebMethod
	@WebResult(name = "response")
	public DeliveryResponse delivery(
			@WebParam(name = "token", header = true) String token,
			@WebParam(name = "mesage") DeliveryRequest request) {
		// TODO Auto-generated method stub
		DeliveryResponse response = new DeliveryResponse();
		response.delivery_id = "111";
		return response;
	}

	@Override
	@WebMethod
	@WebResult(name = "quoteId")
	public String askQuote(
			@WebParam(name = "token", header = true) String token,
			@WebParam(name = "deliveryId") String deliveryId) {
		// TODO Auto-generated method stub
		return deliveryId+"quote";
	}

	@Override
	@WebMethod
	@WebResult(name = "trace")
	public TraceResponse trace(
			@WebParam(name = "token", header = true) String token,
			@WebParam(name = "quoteId") String quoteId) {
		// TODO Auto-generated method stub
		TraceResponse response = new TraceResponse();
		response.E2D = new Date();
		response.location = "Sophia";
		return response;
	}

	@Override
	@WebMethod
	public String getToken(@WebParam(name = "login") String username,
			@WebParam(name = "pwd") String password) {
		// TODO Auto-generated method stub
		return "a_secret_token_" + username;
	}

}
