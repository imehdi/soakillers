package fr.polytech.bank;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.polytech.bank.fault.BankFault;
import fr.polytech.bank.message.AccountRequest;
import fr.polytech.bank.message.AccountResponse;

@WebService(name = "BankServicePortType")
public interface BankService {

	@WebMethod
	@WebResult(name = "accountResponse")
	public AccountResponse account(@WebParam(name = "accountRequest") AccountRequest request, @WebParam(name = "token", header = true) String token) throws BankFault;
}
