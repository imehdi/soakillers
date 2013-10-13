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
public class Address {

	private int id_address;
	private String country;
	private String city;
	private String town;
	private String street_name;
	private int number;

	public Address() {

	}

	public Address(int id_address, String country, String city, String town,
			String street_name, int number) {
		super();
		this.id_address = id_address;
		this.country = country;
		this.city = city;
		this.town = town;
		this.street_name = street_name;
		this.number = number;
	}

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId_address() {
		return id_address;
	}

	public void setId_address(int id_address) {
		this.id_address = id_address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
