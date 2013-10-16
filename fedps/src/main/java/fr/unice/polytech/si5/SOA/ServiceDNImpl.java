package fr.unice.polytech.si5.SOA;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import exception.DeliveryFault;

import message.DeliveryIdMessage;
import message.DeliveryRequest;
import message.TraceResponse;

public class ServiceDNImpl implements ServiceDN {

	@Override
	@WebMethod
	@WebResult(name = "response")
	public DeliveryIdMessage delivery(
			@WebParam(name = "mesage") DeliveryRequest request)
			throws DeliveryFault {
		// TODO Auto-generated method stub
		DeliveryIdMessage response = new DeliveryIdMessage();
		response.delivery_id = "111";
		return response;
	}

	@Override
	@WebMethod
	@WebResult(name = "quoteId")
	public String askQuote(@WebParam(name = "deliveryId") String deliveryId)
			throws DeliveryFault {
		// TODO Auto-generated method stub
		return deliveryId + "quote";
	}

	@Override
	@WebMethod
	@WebResult(name = "trace")
	public TraceResponse trace(@WebParam(name = "quoteId") String quoteId)
			throws DeliveryFault {
		// TODO Auto-generated method stub
		TraceResponse response = new TraceResponse();
		response.E2D = new Date();
		response.location = "Sophia";
		return response;
	}

}
