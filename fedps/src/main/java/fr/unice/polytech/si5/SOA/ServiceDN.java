package fr.unice.polytech.si5.SOA;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;


public interface ServiceDN {

	@WebMethod
	@WebResult(name="response")
	public DeliveryResponse delivery(@WebParam(name="token", header=true)  String token,
								@WebParam(name="mesage") DeliveryRequest request);
	
	@WebMethod
	@WebResult(name="quoteId")
	public String askQuote(@WebParam(name="token", header=true)  String token,
								@WebParam(name="deliveryId")  String deliveryId);
	
	@WebMethod
	@WebResult(name="trace")
	public TraceResponse trace(@WebParam(name="token", header=true)  String token,
								@WebParam(name="quoteId")  String quoteId);
	
	
	@WebMethod
	public String getToken(@WebParam(name="login") String username,
							@WebParam(name="pwd") String password);
}
