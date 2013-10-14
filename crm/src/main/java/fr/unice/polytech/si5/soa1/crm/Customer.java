package fr.unice.polytech.si5.soa1.crm;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;

public class Customer {
	private static int last_id = 0;
	@XmlElement(name="id")
	private int id;
	@XmlElement(name="first_name")
	private String first_name;
	@XmlElement(name="last_name")
	private String last_name;
	@XmlElement(name="address")
	private String address;
	@XmlElement(name="delivery_address")
	private String delivery_address;
	@XmlElement(name="phone_number")
	private String phone_number;
	private HashMap<Integer, Order> orders;
	
	public Customer()
	{
		
	}
	
	public Customer(String customer_first_name, String customer_last_name, String customer_address)
	{
		this(customer_first_name, customer_last_name, customer_address, null, null);
	}

	public Customer(String customer_first_name, String customer_last_name, String customer_address, String customer_delivery_address,
			String customer_phone_number)
	{
		id = ++last_id;
		first_name = customer_first_name;
		last_name = customer_last_name;
		address = customer_address;
		delivery_address = customer_address == null ? address : customer_address;
		phone_number = customer_phone_number == null ? "None" : customer_phone_number;
		orders = new HashMap<Integer, Order>();
	}
	
	public int id()
	{
		return id;
	}
	
	public String toString()
	{
		return id + ", " + first_name + " " + last_name;
	}
	
	public void last_name(String lname)
	{
		last_name = lname;
	}
	
	public void first_name(String fname)
	{
		first_name = fname;
	}
	
	public void address(String cAddress)
	{
		address = cAddress;
	}
	
	public void delivery_Address(String dAddress)
	{
		delivery_address = dAddress;
	}
	
	public void phone_number(String phone)
	{
		phone_number = phone;
	}
	
	public void addOrder(Order o)
	{
		orders.put(o.reference(), o);
	}
	
	public HashMap<Integer, Order> getOrders()
	{
		return orders;
	}
	
}
