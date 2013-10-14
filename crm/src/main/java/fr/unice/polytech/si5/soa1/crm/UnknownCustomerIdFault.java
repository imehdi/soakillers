package fr.unice.polytech.si5.soa1.crm;

public class UnknownCustomerIdFault extends CRMFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7658389062714335796L;
	
	public UnknownCustomerIdFault() {
		super("No customer has been found with this id");
	}

}
