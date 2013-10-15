package fr.unice.polytech.si5.soa1.wm;

import java.util.ArrayList;
import java.util.List;

public class Aisle {

	private Long id;
	private String name;
	private String place;
	private int capacity;
	private List<Category> categories;

	public Aisle() {
	}

	public Aisle(Long id, String name, String place, int capacity) {
		this.id = id;
		this.name = name;
		this.place = place;
		this.capacity = capacity;
		categories = new ArrayList<Category>();
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.setCategories(categories);
	}

	public void addCategories(Category e) {
		this.categories.add(e);
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toJson() {
		String json = "{ \"id\":\"" + id + "\" , " 
	            + "\"name\":\"" + name + "\" , " 
				+ "\"place\":\"" + place + "\" , "
				+ "\"capacity\":\"" + capacity + "\" }";

		return json;
	}
}
