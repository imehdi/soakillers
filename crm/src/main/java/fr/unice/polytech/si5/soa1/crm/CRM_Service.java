package fr.unice.polytech.si5.soa1.crm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="BLueDrinksCRM")
public interface CRM_Service {
	@WebMethod()
	public int addCustomer(@WebParam(name="FirstName") String fname, @WebParam(name="LastName") String lname, @WebParam(name="address") String address);	
	@WebMethod()
	public Customer getCustomer(@WebParam(name="Id") int id) throws UnknownCustomerIdFault;
	@WebMethod()
	public void setCustomer(@WebParam(name="Id") int id, @WebParam(name="key") String key, @WebParam(name="value") String value) throws UnknownCustomerIdFault, UnknownElementFault;
	@WebMethod()
	public Item getItem(@WebParam(name="reference") String reference) throws UnknownItemRefFault;
	@WebMethod()
	public Item[] getCatalog(@WebParam(name="Filter") String filterName, @WebParam(name="value") String value) throws UnknownFilterFault;
	@WebMethod()
	public void buyItem(@WebParam(name="Id") int customerId, @WebParam(name="ref") String itemReference, @WebParam(name="quantity") int quantity) throws UnknownCustomerIdFault, UnknownItemRefFault;
	@WebMethod
	public Item[] getFavoriteItems(@WebParam(name="id") int id) throws UnknownCustomerIdFault;
}
