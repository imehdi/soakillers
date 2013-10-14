package fr.polytech.bank.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AccountResponse")
public class AccountResponse {

	@XmlElement(name = "number", required = true)
	public String accountNumber;

	public AccountResponse() {
	}

	public AccountResponse(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}