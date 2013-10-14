package fr.unice.polytech.si5.soa1.crm;

import java.util.Date;

public class Order {
	private static int lastOrderNumber;
	private int orderNumber;
	private Item item;
	private int quantity;
	private Date orderDate;
	
	public Order(Item bought_item, int item_quantity)
	{
		item = bought_item;
		quantity = item_quantity;
		orderNumber = ++lastOrderNumber;
		orderDate = new Date();
	}
	
	public int reference()
	{
		return orderNumber;
	}
	
	public Item item()
	{
		return item;
	}

}
