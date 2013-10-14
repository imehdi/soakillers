package fr.unice.polytech.si5.soa1.crm;

public class UnknownItemRefFault extends CRMFault {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4744570544835394118L;

	public UnknownItemRefFault()
	{
		super("No item has been found with this reference");
	}
}
