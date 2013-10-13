/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * 
 */

// @Entity
@XmlRootElement
public class Order {

	private int order_id;
	private Account account;
	private List<Product> products;
	private Date date;
	private boolean treated;

	public Order() {

		products = new ArrayList<Product>();
		treated = false;

	}

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	// @OneToOne
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

}
