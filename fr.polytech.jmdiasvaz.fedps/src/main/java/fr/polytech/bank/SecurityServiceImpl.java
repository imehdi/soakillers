package fr.polytech.bank;

import javax.jws.WebService;

import fr.polytech.bank.fault.BankFault;
import fr.polytech.bank.fault.UnauthorizedAccessFault;

@WebService(serviceName = "SecurityService", endpointInterface = "fr.polytech.bank.SecurityService", portName = "SecurityServicePort")
public class SecurityServiceImpl implements SecurityService {

	@Override
	public String getTokens(String username, String password) throws BankFault {
		if (username.equals("authorized") && password.equals("person")) return "ValidToken";
		else throw new UnauthorizedAccessFault();
	}
}
