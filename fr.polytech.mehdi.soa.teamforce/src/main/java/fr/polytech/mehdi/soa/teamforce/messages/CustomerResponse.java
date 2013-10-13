/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import fr.polytech.mehdi.soa.teamforce.dataModel.Account;

/**
 * @author HP
 * 
 */
@XmlType
public class CustomerResponse {

	@XmlElement(name = "account" , required = true)
	public Account account;
}
