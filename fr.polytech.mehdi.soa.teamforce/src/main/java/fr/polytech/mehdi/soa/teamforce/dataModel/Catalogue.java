/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * 
 */


@XmlRootElement
public class Catalogue {

	private int catalogue_id;
	private String catalogue_name;
	private List<Product> products;

	public Catalogue() {
		super();
		products = new ArrayList<Product>();
	}

	
	public int getCatalogue_id() {
		return catalogue_id;
	}

	public void setCatalogue_id(int catalogue_id) {
		this.catalogue_id = catalogue_id;
	}

	public String getCatalogue_name() {
		return catalogue_name;
	}

	public void setCatalogue_name(String catalogue_name) {
		this.catalogue_name = catalogue_name;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		products.add(product);

	}

}
