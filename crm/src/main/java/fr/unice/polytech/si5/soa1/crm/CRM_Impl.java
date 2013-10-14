package fr.unice.polytech.si5.soa1.crm;

import javax.jws.WebParam;

public class CRM_Impl implements CRM_Service
{
	//Elements that can be modified on customer
	private static String lName_Key = "lNameKey";
	private static String fName_Key = "fNameKey";
	private static String address = "addressKey";
	private static String dAddress = "dAddressKey";
	private static String phone = "phoneKey";
	//filter type
	private static String categoryFilter = "categoryFilter";
	private static String nameFilter = "nameFilter";
	
	public int addCustomer(@WebParam(name = "First Name") String fname, @WebParam(name = "Last Name") String lname,
			@WebParam(name="address") String address) {
		return DataBase.getDataBase().addCustomer(new Customer(fname, lname, address));
	}

	public Customer getCustomer(@WebParam(name = "Id") int id) throws UnknownCustomerIdFault {
		return DataBase.getDataBase().getCustomer(id);
	}

	public Item getItem(@WebParam(name = "reference") String reference) throws UnknownItemRefFault {
		return DataBase.getDataBase().getItem(reference);
	}

	public void setCustomer(@WebParam(name="Id") int id, @WebParam(name = "key") String key,
			@WebParam(name = "value") String value) throws UnknownCustomerIdFault, UnknownElementFault {
		Customer c = DataBase.getDataBase().getCustomer(id);
		if(lName_Key.equals(key))
		{
			c.last_name(value);
		}
		else if(fName_Key.equals(key))
		{
			c.first_name(value);
		}
		else if(address.equals(key))
		{
			c.address(value);
		}
		else if(dAddress.equals(key))
		{
			c.delivery_Address(value);
		}
		else if(phone.equals(key))
		{
			c.phone_number(value);
		}
		else
		{
			throw new UnknownElementFault();
		}
	}

	public Item[] getCatalog(
			@WebParam(name = "Filter") String filterName,
			@WebParam(name = "value") String value) throws UnknownFilterFault {
		if(filterName == null || value == null)
		{
			throw new UnknownFilterFault();
		}
		if(filterName.isEmpty())
		{
			return DataBase.getDataBase().getCatalog();
		}
		if(nameFilter.equals(filterName))
		{
			return DataBase.getDataBase().getCatalogByName(value);
		}
		if(categoryFilter.equals(filterName))
		{
			CATEGORY cat = CATEGORY.valueOf(value);
			return DataBase.getDataBase().getCatalogByCategory(cat);
		}
		throw new UnknownFilterFault();
	}

	public void buyItem(@WebParam(name = "Id") int customerId,
			@WebParam(name = "ref") String itemReference,
			@WebParam(name = "quantity") int quantity) throws UnknownCustomerIdFault, UnknownItemRefFault {
		Item i = DataBase.getDataBase().getItem(itemReference);
		Customer c = DataBase.getDataBase().getCustomer(customerId);
		DataBase.getDataBase().storeOrder(c, i, quantity);
	}

	public Item[] getFavoriteItems(@WebParam(name="id") int id) throws UnknownCustomerIdFault {
		Customer c = DataBase.getDataBase().getCustomer(id);
		return DataBase.getDataBase().getFavoriteItems(c);
	}
	
}
