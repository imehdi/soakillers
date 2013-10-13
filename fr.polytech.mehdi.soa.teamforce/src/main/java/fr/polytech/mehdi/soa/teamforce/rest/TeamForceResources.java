/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import fr.polytech.mehdi.soa.teamforce.dataModel.Account;
import fr.polytech.mehdi.soa.teamforce.dataModel.Catalogue;
import fr.polytech.mehdi.soa.teamforce.dataModel.Customer;
import fr.polytech.mehdi.soa.teamforce.dataModel.Factory;
import fr.polytech.mehdi.soa.teamforce.dataModel.Order;
import fr.polytech.mehdi.soa.teamforce.dataModel.Product;

/**
 * @author HP
 * 
 */

@Path("teamforce")
public class TeamForceResources {

	private Logger logger = Logger
			.getLogger(TeamForceResources.class.getName());

	public TeamForceResources() {

	}

	@GET
	@Path("/Customer/{customer_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Customer getCustomer(@PathParam("customer_id") double customer_id) {

		logger.info("getting customer");

		for (Customer c : Factory.getInstance().getCustomers()) {

			if (c.getCustomer_id() == customer_id)
				return c;

		}

		logger.info("customer doesn't exist");
		return null;

	}

	@GET
	@Path("/Product/{Product_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Product getProductByID(@PathParam("Product_id") double product_id) {

		logger.info("getting product by id");
		for (Product p : Factory.getInstance().getProducts()) {

			if (p.getProduct_id() == product_id)
				return p;

		}

		logger.info("product doesn't exist");
		return null;

	}

	@GET
	@Path("/Account/{account_id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Account getAccountByID(@PathParam("account_id") int account_id) {

		logger.info("getting account by id");
		for (Account c : Factory.getInstance().getAccounts()) {

			if (c.getAccount_id() == account_id)

				return c;

		}

		logger.info("account doesn't exist");
		return null;
	}

	@GET
	@Path("/Catalogue/{catalogue_name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Catalogue getCatalogueByName(
			@PathParam("catalogue_name") String catalogue_name) {

		logger.info("getting catalog by name");
		for (Catalogue c : Factory.getInstance().getCatalogues()) {

			if (c.getCatalogue_name().equals(catalogue_name))
				return c;

		}

		logger.info("catalog doesn't exist");
		return null;
	}

	@GET
	@Path("/Order/Account/{account_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Order> getOrdersByCustomer(
			@PathParam("account_id") double account_id) {

		logger.info("getting orders by customer");
		List<Order> orders = new ArrayList<Order>();

		for (Order o : Factory.getInstance().getOrders()) {

			if (o.getAccount().getAccount_id() == account_id)
				orders.add(o);

		}
		if (orders.size() == 0) {
			logger.info("no orders for this customer");
			return null;
		}

		logger.info("account doesn't exist");
		return orders;

	}

	@GET
	@Path("/Order/{order_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Order getOrderByID(@PathParam("order_id") int order) {
		logger.info("getting order by id");
		for (Order c : Factory.getInstance().getOrders()) {

			if (c.getOrder_id() == order)
				return c;

		}
		logger.info("order doesn't exist");
		return null;
	}

	@GET
	@Path("/Account/Customer/{account_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Product> getPreferedProducts(
			@PathParam("account_id") double account_id) {

		logger.info("getting account by id");
		for (Account acc : Factory.getInstance().getAccounts()) {

			if (acc.getAccount_id() == account_id)
				return acc.getProducts();

		}
		logger.warn("no prefered products");
		return new ArrayList<Product>();
	}

}
