package fr.polytech.bank;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.polytech.bank.fault.BankFault;

@WebService(name = "SecurityServicePortType")
public interface SecurityService {

	@WebMethod
	@WebResult(name = "token")
	public String getTokens(@WebParam(name = "id") String username, @WebParam(name = "pwd") String password) throws BankFault;

}
