package fr.unice.polytech.si5.soa1.crm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

//this class simulates the behaviour of a database, each function miçght as well be replaced with a real call to a db
public class DataBase {
	public HashMap<Integer, Customer> customers;
	public HashMap<String, Item> catalog;
	
	private static DataBase singleton = null;
	
	private DataBase()
	{
		//initializing some data in the db
		customers = new HashMap<Integer, Customer>();
		catalog = new HashMap<String, Item>();
		
		Customer c1 = new Customer("Adrien", "Palomba", "Nice");
		addCustomer(c1);		
		Customer c2 = new Customer("Bob", "Marley", "Jamaica", "Nice", "0123456789");
		addCustomer(c2);
		
		Item i1 = new Item("Vin du Var", 231.92, CATEGORY.wine);
		i1.addAttribute("Year", "1986");
		i1.addAttribute("Volume", "0.75cl");
		//A trick for tests, useless in real life
		i1.reference("F890UIOPO");
		addItem(i1);
		Item i2 = new Item("Eau de source de Lyon", 0.78, CATEGORY.water);
		i2.addAttribute("Volume", "1L");
		i2.reference("0880IHIU");
		addItem(i2);
	}
	
	public static DataBase getDataBase()
	{
		//THE db is a singleton
		if(singleton == null)
		{
			singleton = new DataBase();
		}
		return singleton;
	}
	
	public int addCustomer(Customer c)
	{
		customers.put(c.id(), c);
		System.out.println("Customer added to the CRM : " + c);
		return c.id();
	}
	
	public Customer getCustomer(int id) throws UnknownCustomerIdFault
	{
		Customer c = customers.get(id);
		if(c == null)
		{
			throw new UnknownCustomerIdFault();
		}
		return c;
	}
	
	public String addItem(Item i)
	{
		catalog.put(i.reference(), i);
		System.out.println("Item added to the Catalog : " + i);
		return i.reference();
	}
	
	public Item getItem(String reference) throws UnknownItemRefFault
	{
		Item i = catalog.get(reference);
		if(i == null)
		{
			throw new UnknownItemRefFault();
		}
		return i;
	}
	
	public Item[] getCatalog()
	{
		return (catalog.values().toArray(new Item[0]));
	}
	
	public Item[] getCatalogByCategory(CATEGORY value)
	{
		ArrayList<Item> res = new ArrayList<Item>(); 
		for(Entry<String, Item> i : catalog.entrySet())
		{
			if(value.equals(i.getValue().category()))
			{
				res.add(i.getValue());
			}
		}
		return res.toArray(new Item[0]);
	}
	
	public Item[] getCatalogByName(String value)
	{
		ArrayList<Item> res = new ArrayList<Item>();
		for(Entry<String, Item> i : catalog.entrySet())
		{
			if(value.equals(i.getValue().label()))
			{
				res.add(i.getValue());
			}
		}
		return res.toArray(new Item[0]);
	}
	
	public void storeOrder(Customer c, Item i, int quantity)
	{
		c.addOrder(new Order(i, quantity));
	}
	
	public Item[] getFavoriteItems(Customer c)
	{
		HashMap<String, Item> favorites = new HashMap<String, Item>();
		for(Order o : c.getOrders().values())
		{
			Item i = o.item();
			favorites.put(i.reference(), i);
		}
		return favorites.values().toArray(new Item[0]);
	}
}
