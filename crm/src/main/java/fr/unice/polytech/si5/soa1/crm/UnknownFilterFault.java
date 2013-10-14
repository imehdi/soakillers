package fr.unice.polytech.si5.soa1.crm;

public class UnknownFilterFault extends CRMFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2837846357731944113L;

	public UnknownFilterFault() {
		super("This filter is incorrect");
	}
}
