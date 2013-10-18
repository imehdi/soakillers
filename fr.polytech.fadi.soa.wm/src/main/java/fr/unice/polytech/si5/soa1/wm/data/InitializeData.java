package fr.unice.polytech.si5.soa1.wm.data;

import java.io.File;
import java.text.ParseException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import fr.unice.polytech.si5.soa1.wm.model.*;

public class InitializeData {

    String aislesYAKLocation;
    String categoriesYAKLocation;
    String productsYAKLocation;
    String productsOperationsYAKLocation;

    File aislesYAKData;
    File categoriesYAKData;
    File productsYAKData;
    File productsOperationsYAKData;

    ObjectContainer dbAisles;
    ObjectContainer dbCategories;
    ObjectContainer dbProducts;
    ObjectContainer dbProductsOperations;
	
    AisleFacade aF;
    CategoryFacade cF;
    ProductFacade pF;
    ProductOperationFacade pOF;
    
    public InitializeData() {	
    	aislesYAKLocation = "yak-data/aisles-yak-data.yak";
    	categoriesYAKLocation = "yak-data/categories-yak-data.yak";
    	productsYAKLocation = "yak-data/products-yak-data.yak";
    	productsOperationsYAKLocation = "yak-data/products-operations-yak-data.yak";
    	
    	aislesYAKData = new File(aislesYAKLocation);
    	categoriesYAKData = new File(categoriesYAKLocation);
    	productsYAKData = new File(productsYAKLocation);
    	productsOperationsYAKData = new File(productsOperationsYAKLocation);
    	
    	dbAisles = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), aislesYAKLocation);
    	dbCategories = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), categoriesYAKLocation);
    	dbProducts = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), productsYAKLocation);
    	dbProductsOperations = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), productsOperationsYAKLocation);
    	
    	aF = new AisleFacade(dbAisles);
    	cF = new CategoryFacade(dbCategories);
    	pF = new ProductFacade(dbProducts);
    	pOF = new ProductOperationFacade(dbProductsOperations);
	}

	// Aisles Operations
	public void createAisles() {
		Aisle a1 = new Aisle("1A", "Stage 1 Section A", 100);
		aF.create(a1);
	}

	// Categories Operations
	public void createCategories() {
		Category c1 = new Category("Electric Guitars",
				"This category is for electric guitars",
				aF.find((long) 1));
		cF.create(c1);
	}

	// Products Operations
	public void createProducts() {
		Product p1 = new Product("Ibanez RG350DX",
				"Electric Guitar made in Indonisia", 350, 370, 10, 13, 70, 30,
				10, cF.find((long) 1));
		pF.create(p1);
	}

	// Product operation operations
	public void createProductsOperations() throws ParseException,
			ProductOperationExceptions {
		ProductOperation pO1 = new ProductOperation("x",
				pF.find((long) 1), true, 2, "05:41,15/10/2013");
		pOF.create(pO1);
	}

	public void addProductOperation(ProductOperation pO) {
		pOF.create(pO);
	}

	public void initializeData() throws ParseException,
			ProductOperationExceptions {
		// We must use these calls in order because there's a code dependency
		// like the main exactly.
		this.createAisles();
		this.createCategories();
		this.createProducts();
		this.createProductsOperations();
	}
	
	public static void main(String[] args){
		InitializeData iD = new InitializeData();
		try {
			iD.initializeData();
			
			for (Product p: iD.pF.findAll()){
				System.out.println(p.getId() + " " + p.getName());
			}
			
			iD.dbAisles.close();
		    iD.dbCategories.close();
		    iD.dbProducts.close();
		    iD.dbProductsOperations.close();
		    System.out.println("\nDone");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ProductOperationExceptions e) {
			e.printStackTrace();
		}
	}
}