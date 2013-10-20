/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * 
 */


@XmlRootElement
public class Product {

	private double product_id;
	private String product_name;
	private int product_quantity;
	private double product_price ;

	
	public Product(double product_id, String product_name, int product_quantity , double product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.product_price = product_price ;

	}

	public Product() {
		super();
	}

	
	public double getProduct_id() {
		return product_id;
	}

	public void setProduct_id(double product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	
	

}
