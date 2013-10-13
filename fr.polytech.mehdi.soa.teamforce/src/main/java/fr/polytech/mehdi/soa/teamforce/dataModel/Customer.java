/**
 * 
 */
package fr.polytech.mehdi.soa.teamforce.dataModel;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * 
 */

// @Entity
@XmlRootElement
public class Customer {

	private double customer_id;
	private String customer_name;
	private String customer_lastname;
	private int customer_age;
	private char customer_gender;
	private Address address;

	public Customer() {

	}

	public Customer(double customer_id, String customer_name,
			String customer_lastname, int customer_age, char customer_gender,
			Address address) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_lastname = customer_lastname;
		this.customer_age = customer_age;
		this.customer_gender = customer_gender;
		this.address = address;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_lastname() {
		return customer_lastname;
	}

	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}

	public int getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}

	public char getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(char customer_gender) {
		this.customer_gender = customer_gender;
	}

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	public double getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(double customer_id) {
		this.customer_id = customer_id;
	}

	// @OneToOne
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
