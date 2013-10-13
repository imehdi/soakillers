/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * 
 */

// @Entity
@XmlRootElement
public class Product {

	private double product_id;
	private String product_name;
	private int product_quantity;

	public Product(double product_id, String product_name, int product_quantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_quantity = product_quantity;

	}

	public Product() {
		super();
	}

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
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

}
