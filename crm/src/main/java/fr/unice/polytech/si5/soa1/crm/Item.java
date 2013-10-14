package fr.unice.polytech.si5.soa1.crm;

import java.util.HashMap;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;

public class Item {
	@XmlElement(name="label")
	private String label;
	@XmlElement(name="price")
	private double price;
	@XmlElement(name="reference")
	private String reference;
	@XmlElement(name="category")
	private CATEGORY category;
	private HashMap<String, String> attributes;
	
	public Item()
	{
		
	}
	
	public Item(String item_label, double item_price, CATEGORY item_category)
	{
		category = item_category;
		price = item_price;
		label = item_label;
		reference = UUID.randomUUID().toString();
		attributes = new HashMap<>();
	}
	
	public void addAttribute(String name, String value)
	{
		attributes.put(name,  value);
	}
	
	public String reference()
	{
		return reference;
	}
	
	public String toString()
	{
		return reference.toString() + ", " + label + " : " + price;
	}
	
	public CATEGORY category()
	{
		return category;
	}
	
	public String label()
	{
		return label;
	}
	
	public void reference(String ref)
	{
		reference = ref;
	}
}
