package fr.unice.polytech.si5.soa1.wm;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private Long id;
	private String name;
	private String description;
	private Aisle aisle;
	private List<Product> products;

	public Category() {
	}

	public Category(Long id, String name, String description, Aisle aisle) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.aisle = aisle;
		products = new ArrayList<Product>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProducts(Product p) {
		this.products.add(p);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Aisle getAisle() {
		return aisle;
	}

	public void setAisle(Aisle aisle) {
		this.aisle = aisle;
	}

	public String toJson() {
		String json = "{ \"id\":\"" + id + "\" , " 
	            + "\"name\":\"" + name + "\" , " 
				+ "\"description\":\"" + description + "\" , "
				+ "\"aisleId\":\"" + aisle.getId() + "\" }";

		return json;
	}
}
