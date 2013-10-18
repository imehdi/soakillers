package fr.unice.polytech.si5.soa1.wm.model;

public class Product {

	private Long id;
	private String name;
	private String description;
	private int unitPriceFromSupplier;
	private int unitPriceForCustomer;
	private int unitsInStock;
	// Weight is in pound.
	private int weight;
	// Dimension in cm.
	private int width;
	private int length;
	private int height;

	private Category category;

	public Product() {
	}

	public Product(Long id) {
		this.id = id;
	}
	
	public Product(String name, String description,
			int unitPriceFromSupplier, int unitPriceForCustomer,
			int unitsInStock, int weight, int length, int width, int height,
			Category category) {
		super();
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.unitPriceFromSupplier = unitPriceFromSupplier;
		this.unitPriceForCustomer = unitPriceForCustomer;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.category = category;
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

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitPriceFromSupplier() {
		return unitPriceFromSupplier;
	}

	public void setUnitPriceFromSupplier(int unitPriceFromSupplier) {
		this.unitPriceFromSupplier = unitPriceFromSupplier;
	}

	public int getUnitPriceForCustomer() {
		return unitPriceForCustomer;
	}

	public void setUnitPriceForCustomer(int unitPriceForCustomer) {
		this.unitPriceForCustomer = unitPriceForCustomer;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toJson() {
		String json = "{ \"id\":\"" + id + "\" , " 
	            + "\"name\":\"" + name + "\" , " 
				+ "\"description\":\"" + description + "\" , "
				+ "\"unitPriceFromSupplier\":\"" + unitPriceFromSupplier + "\" , " 
				+ "\"unitPriceForCustomer\":\"" + unitPriceForCustomer + "\" , " 
				+ "\"unitsInStock\":\"" + unitsInStock + "\" , " 
				+ "\"weight\":\"" + weight + "\" , "
				+ "\"length\":\"" + length + "\" , " 
				+ "\"width\":\"" + width + "\" , " 
				+ "\"height\":\"" + height + "\" , "
				+ "\"categoryId\":\"" + category.getId() + "\" }";

		return json;
	}
	
	public String locationToJson() {
		String json = "{ \"id\":\"" + id + "\" , "
				+ "\"location\":\"" + category.getAisle().getName()
				+ "\" }";
		return json;
	}
}