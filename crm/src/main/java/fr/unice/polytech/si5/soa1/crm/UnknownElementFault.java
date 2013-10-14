package fr.unice.polytech.si5.soa1.crm;

public class UnknownElementFault extends CRMFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2472540926045986946L;

	public UnknownElementFault() {
		super("This element can't be applied to the customer");
	}
}
