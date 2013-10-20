/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.polytech.mehdi.soa.teamforce.messages.CustomerRequest;
import fr.polytech.mehdi.soa.teamforce.messages.CustomerResponse;
import fr.polytech.mehdi.soa.teamforce.messages.OrderRequest;
import fr.polytech.mehdi.soa.teamforce.messages.OrderResponse;

/**
 * @author HP
 * 
 */

@WebService(name = "teamforce")
public interface ITeamForce {

	@WebMethod
	public CustomerResponse addCustomer(
			@WebParam(name = "Customer") CustomerRequest customerRequest);

	@WebMethod
	public OrderResponse addOrder(
			@WebParam(name = "new_order") OrderRequest orderRequest);

}
