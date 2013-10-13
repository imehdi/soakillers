/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author HP
 * 
 */

@XmlType
public class OrderRequest {

	// @XmlElement(name = "new_order" , required = true)
	// public Order order ;

	@XmlElement(name = "account_id", required = true)
	public int account_id;

	@XmlElement(name = "treated", required = true)
	public boolean treated;

	@XmlElement(name = "products_id", required = true)
	public double products_id[];

	@XmlElement(name = "order_date", required = true)
	public String orderDate;

	@XmlElement(name = "order_id", required = true)
	public int order_id;
}
