/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.serviceImpl;

import javax.jws.WebService;

import fr.polytech.mehdi.soa.teamforce.messages.CustomerRequest;
import fr.polytech.mehdi.soa.teamforce.messages.CustomerResponse;
import fr.polytech.mehdi.soa.teamforce.messages.OrderRequest;
import fr.polytech.mehdi.soa.teamforce.messages.OrderResponse;
import fr.polytech.mehdi.soa.teamforce.service.ITeamForce;

/**
 * @author HP
 * 
 */
@WebService(endpointInterface = "fr.polytech.mehdi.soa.teamforce.service.ITeamForce")
public class TeamForceImpl extends TeamForceBusiness implements ITeamForce {

	public CustomerResponse addCustomer(CustomerRequest customerRequest) {

		return super.addCustomer(customerRequest);

	}

	public OrderResponse addOrder(OrderRequest orderRequest) {

		return super.addOrder(orderRequest);
	}

}
