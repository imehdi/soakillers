package fr.unice.polytech.si5.SOA;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import exception.DeliveryFault;

import message.DeliveryIdMessage;
import message.DeliveryRequest;
import message.TraceResponse;

public interface ServiceDN {

	@WebMethod
	@WebResult(name = "response")
	public DeliveryIdMessage delivery (
			@WebParam(name = "mesage") DeliveryRequest request) throws DeliveryFault;

	@WebMethod
	@WebResult(name = "quoteId")
	public String askQuote(@WebParam(name = "deliveryId") String deliveryId) throws DeliveryFault;

	@WebMethod
	@WebResult(name = "trace")
	public TraceResponse trace(@WebParam(name = "quoteId") String quoteId) throws DeliveryFault;

}
