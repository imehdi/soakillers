/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import fr.polytech.mehdi.soa.teamforce.dataModel.Customer;

/**
 * @author HP
 *
 */
@XmlType (name = "CustomerRequest")
public class CustomerRequest {
	
	@XmlElement(name = "customer" ,  required = true)
	public Customer customer ;

}
