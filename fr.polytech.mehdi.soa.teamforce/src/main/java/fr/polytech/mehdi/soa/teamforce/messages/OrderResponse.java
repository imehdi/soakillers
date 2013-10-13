/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import fr.polytech.mehdi.soa.teamforce.dataModel.Order;

/**
 * @author HP
 * 
 */

@XmlType
public class OrderResponse {

	@XmlElement(name = "order", required = true)
	public Order order;

}
