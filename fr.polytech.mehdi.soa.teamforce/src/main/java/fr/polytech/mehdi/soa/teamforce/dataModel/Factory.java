/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author HP
 * 
 */
public class Factory {

	private Set<Order> orders;
	private Set<Catalogue> catalogues;
	private Set<Account> accounts;
	private Set<Address> address;
	private Set<Product> products;
	private Set<Customer> customers;
	private static Factory factory;
	private Logger logger = Logger.getLogger(Factory.class.getName()) ;

	/**
	 * 
	 */
	private Factory() {

		orders = new HashSet<Order>();
		catalogues = new HashSet<Catalogue>();
		accounts = new HashSet<Account>();
		address = new HashSet<Address>();
		products = new HashSet<Product>();
		customers = new HashSet<Customer>();

		// products

		Product product1 = new Product(1, "G-StAR", 150 , 78);
		Product product2 = new Product(2, "pepe jeans", 150 , 65);
		Product product3 = new Product(3, "levis", 186 , 92);
		Product product4 = new Product(4, "Lacost", 75 , 36 );
		Product product5 = new Product(5, "Tommy", 150 , 69);
		Product product6 = new Product(6, "Zara", 36 , 19);
		Product product7 = new Product(7, "Celio", 136 , 23);
		products.add(product7);
		products.add(product6);
		products.add(product5);
		products.add(product4);
		products.add(product3);
		products.add(product2);
		products.add(product1);

		// Catalogues

		Catalogue catalogue1 = new Catalogue();
		catalogue1.setCatalogue_id(1);
		catalogue1.setCatalogue_name("Jeans");
		catalogue1.addProduct(product1);
		catalogue1.addProduct(product2);
		catalogue1.addProduct(product3);

		catalogues.add(catalogue1);

		Catalogue catalogue2 = new Catalogue();
		catalogue2.setCatalogue_id(2);
		catalogue2.setCatalogue_name("T-shirts");
		catalogue2.addProduct(product4);
		catalogue2.addProduct(product5);
		catalogue2.addProduct(product6);
		catalogue2.addProduct(product7);

		catalogues.add(catalogue2);

		// address

		Address address1 = new Address(1, "France", "Cote d'azure", "Antibes",
				"1ère Avenue", 670);
		Address address2 = new Address(2, "Tunisie", "Ariana", "ElGhazela",
				"Residence Nader", 12);

		address.add(address1);
		address.add(address2);

		// Customers

		Customer customer1 = new Customer(1, "Mohamed", "AIDOUDI", 29, 'M',
				address1);
		Customer customer2 = new Customer(2, "Nourhene", "BenRabah", 24, 'f',
				address2);

		customers.add(customer1);
		customers.add(customer2);

		// Accounts

		Account account1 = new Account();
		account1.setAccount_id(1);
		account1.setCustomer(customer1);
		account1.addProduct(product2);
		account1.addProduct(product7);

		Account account2 = new Account();
		account2.setAccount_id(2);
		account2.setCustomer(customer2);
		account2.addProduct(product6);
		account2.addProduct(product3);
		
		

		// Orders

		Order order1 =  new Order(); 
		order1.setDate(new Date());
		order1.setAccount(account1);
		order1.setOrder_id(1);
		order1.addProduct(product6);
		order1.addProduct(product4);
		
		Order order2 =  new Order(); 
		order2.setDate(new Date());
		order2.setAccount(account2);
		order2.setOrder_id(2);
		order2.addProduct(product3);
		order2.addProduct(product7);
		
		Order order3 =  new Order(); 
		order3.setDate(new Date());
		order3.setAccount(account1);
		order3.setOrder_id(3);
		order3.addProduct(product5);
		order3.addProduct(product2);
		
		
		
		accounts.add(account1);
		accounts.add(account2);
		
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
	}

	public static Factory getInstance() {

		if (factory == null)
			factory = new Factory();

		return factory;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Catalogue> getCatalogues() {
		logger.info(catalogues.size());
		return catalogues;
	}

	public void setCatalogues(Set<Catalogue> catalogues) {
		this.catalogues = catalogues;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
