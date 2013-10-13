/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author HP
 * 
 */

// @Entity
@XmlType
@XmlRootElement
public class Account {

	private int account_id;
	private Customer customer;
	private List<Product> products;
	private List<Order> orders;

	public Account() {

		products = new ArrayList<Product>();
		orders = new ArrayList<Order>();
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// @OneToMany(cascade = CascadeType.ALL)
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addProduct(Product e) {

		products.add(e);
	}

	public void addOrder(Order order) {

		orders.add(order);
		
	}

}
