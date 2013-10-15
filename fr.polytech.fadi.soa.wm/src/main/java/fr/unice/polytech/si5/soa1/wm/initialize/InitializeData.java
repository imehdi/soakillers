package fr.unice.polytech.si5.soa1.wm.initialize;

import java.text.ParseException;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import fr.unice.polytech.si5.soa1.wm.*;

public class InitializeData {

	private List<Category> categories;
	private List<Product> products;
	private List<Aisle> aisles;
	private List<ProductOperation> productsOperations;

	public InitializeData() {
		categories = new ArrayList<Category>();
		products = new ArrayList<Product>();
		aisles = new ArrayList<Aisle>();
		productsOperations = new ArrayList<ProductOperation>();
		try {
			this.initializeData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Aisles Operations
	public void createAisles() {
		Aisle a1 = new Aisle((long) 1, "1A", "Stage 1 Section A", 100);
		aisles.add(a1);
	}

	public Aisle getAisleById(Long id) {
		for (Aisle aisle : aisles) {
			if (aisle.getId() == id) {
				return aisle;
			}
		}
		return null;
	}

	// Categories Operations
	public void createCategories() {

		Category c1 = new Category((long) 1, "Electric Guitars",
				"This category is for electric guitars",
				this.getAisleById((long) 1));
		categories.add(c1);
	}

	public Category getCategoryById(Long id) {
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	// Products Operations
	public void createProducts() {
		Product p1 = new Product((long) 1, "Ibanez RG350DX",
				"Electric Guitar made in Indonisia", 350, 370, 10, 13, 70, 30,
				10, this.getCategoryById((long) 1));
		products.add(p1);
	}

	public Product getProductById(Long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public long getProductAutoIncreId(List<Product> products) {
		long maxId = 0;
		for (Product p : products) {
			if (p.getId() > maxId) {
				maxId = p.getId();
			}
		}
		return ++maxId;
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	// Product operation operations
	public void createProductsOperations() throws ParseException {
		ProductOperation pO1 = new ProductOperation((long) 1, "x",
				this.getProductById((long) 1), true, 2, "05:41,15/10/2013");
		this.productsOperations.add(pO1);
	}

	public long getProductOperationAutoIncreId(
			List<ProductOperation> productsOperations) {
		long maxId = 0;
		for (ProductOperation pO : productsOperations) {
			if (pO.getId() > maxId) {
				maxId = pO.getId();
			}
		}
		return ++maxId;
	}

	public void addProductOperation(ProductOperation oP) {
		productsOperations.add(oP);
	}

	public ProductOperation performProductOperationFromJSON(JSONObject obj) {
		ProductOperation oP;
		try {
			oP = new ProductOperation(this.getProductOperationAutoIncreId(this
					.getProductsOperations()), obj.getString("company"),
					this.getProductById((long) obj.getInt("productId")),
					Boolean.parseBoolean(obj.getString("consume")),
					obj.getInt("quantity"), obj.getString("orderDate"));
			this.addProductOperation(oP);
			return oP;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Setters and getters
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Aisle> getAisles() {
		return aisles;
	}

	public void setAisles(List<Aisle> aisles) {
		this.aisles = aisles;
	}

	public List<ProductOperation> getProductsOperations() {
		return productsOperations;
	}

	public void setProductsOperations(List<ProductOperation> productsOperations) {
		this.productsOperations = productsOperations;
	}

	public void initializeData() throws ParseException {
		// We must use these calls in order because there's a code dependency
		// like the main exactly.
		this.createAisles();
		this.createCategories();
		this.createProducts();
		this.createProductsOperations();
	}
}