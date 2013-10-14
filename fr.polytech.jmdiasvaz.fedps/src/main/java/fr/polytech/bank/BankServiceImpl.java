package fr.polytech.bank;

import javax.jws.WebService;

import fr.polytech.bank.fault.AlreadyRegisteredFault;
import fr.polytech.bank.fault.BankFault;
import fr.polytech.bank.fault.UnauthorizedAccessFault;
import fr.polytech.bank.fault.UnknownAccountTypeFault;
import fr.polytech.bank.fault.UnknownGoalFault;
import fr.polytech.bank.message.AccountRequest;
import fr.polytech.bank.message.AccountResponse;

@WebService(serviceName = "BankService", endpointInterface = "fr.polytech.bank.BankService", portName = "BankServicePort")
public class BankServiceImpl implements BankService {

	@Override
	public AccountResponse account(AccountRequest request, String token) throws BankFault {
		if (isValidToken(token)) return handleRequest(request);
		else throw new UnauthorizedAccessFault();
	}

	private boolean isValidToken(String token) {
		if (token.equals("ValidToken")) return true;
		else return false;
	}

	private AccountResponse handleRequest(AccountRequest rq) throws BankFault {
		if (rq.goal.equals("CREATE")) {
			if (!isRegistered(rq.customerID)) {
				if (isValidType(rq.type))
					return new AccountResponse("001");
				else
					throw new UnknownAccountTypeFault();
			} else
				throw new AlreadyRegisteredFault();
		} else
			throw new UnknownGoalFault();
	}

	private boolean isRegistered(String id) {
		if (id.equals("alreadyAnAccount"))
			return true;
		else
			return false;
	}

	private boolean isValidType(String type) {
		if (type.equals("TR") || type.equals("SA"))
			return true;
		else
			return false;
	}
}