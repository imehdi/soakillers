package fr.polytech.bank.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AccountRequest")
public class AccountRequest {

	@XmlElement(name = "goal", required = true)
	public String goal;
	
	@XmlElement(name = "id", required = true)
	public String customerID;

	@XmlElement(name = "type", required = true)
	public String type;

	public AccountRequest() {
	}

	public AccountRequest(String customerID, String type) {
		this.customerID = customerID;
		this.type = type;
	}
}