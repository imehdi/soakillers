/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import fr.polytech.mehdi.soa.teamforce.dataModel.Account;
import fr.polytech.mehdi.soa.teamforce.dataModel.Factory;
import fr.polytech.mehdi.soa.teamforce.dataModel.Order;
import fr.polytech.mehdi.soa.teamforce.dataModel.Product;
import fr.polytech.mehdi.soa.teamforce.messages.CustomerRequest;
import fr.polytech.mehdi.soa.teamforce.messages.CustomerResponse;
import fr.polytech.mehdi.soa.teamforce.messages.OrderRequest;
import fr.polytech.mehdi.soa.teamforce.messages.OrderResponse;

/**
 * @author HP This class is to implement the business logic of Team force SOAP
 *         service
 */

public class TeamForceBusiness {

	private Logger logger = Logger.getLogger(TeamForceBusiness.class.getName());
	private Factory factory = Factory.getInstance();

	/**
	 * @param CustomerRequest
	 *            received object from the client
	 * @return void
	 * 
	 */
	public CustomerResponse addCustomer(CustomerRequest customerRequest) {

		logger.info("adding new customer");
		customerRequest.customer.setCustomer_id(new Random().nextDouble());
		factory.getCustomers().add(customerRequest.customer);
		Account account = new Account();
		account.setCustomer(customerRequest.customer);
		account.setAccount_id(new Random().nextInt());
		factory.getAccounts().add(account);

		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.account = account;

		return customerResponse;

	}

	public OrderResponse addOrder(OrderRequest orderRequest) {

		logger.info("adding new order");
		Account account = null;

		Order order = new Order();

		OrderResponse orderResponse = new OrderResponse();

		for (Account ac : factory.getAccounts()) {

			if (orderRequest.account_id == ac.getAccount_id()) {

				account = ac;
				break;
			}
		}

		order.setAccount(account);
		order.setProducts(getProductsByOrder(orderRequest.products_id));
		order.setDate(new Date());
		order.setOrder_id(new Random().nextInt());
		order.setTreated(false);
		factory.getOrders().add(order);
		orderResponse.order = order;
		return orderResponse;

	}

	private List<Product> getProductsByOrder(double products_id[]) {

		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < products_id.length; i++) {

			for (Product prod : factory.getProducts()) {

				if (prod.getProduct_id() == products_id[i]) {
					prod.setProduct_quantity(prod.getProduct_quantity() - 1);
					products.add(prod);
					break;
				}

			}
		}

		return products;
	}
}
