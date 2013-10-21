
package fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://service.teamforce.soa.mehdi.polytech.fr/}address" minOccurs="0"/>
 *         &lt;element name="customer_age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customer_gender" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="customer_id" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="customer_lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customer_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "address",
    "customerAge",
    "customerGender",
    "customerId",
    "customerLastname",
    "customerName"
})
public class Customer {

    protected Address address;
    @XmlElement(name = "customer_age")
    protected int customerAge;
    @XmlElement(name = "customer_gender")
    @XmlSchemaType(name = "unsignedShort")
    protected int customerGender;
    @XmlElement(name = "customer_id")
    protected double customerId;
    @XmlElement(name = "customer_lastname")
    protected String customerLastname;
    @XmlElement(name = "customer_name")
    protected String customerName;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the customerAge property.
     * 
     */
    public int getCustomerAge() {
        return customerAge;
    }

    /**
     * Sets the value of the customerAge property.
     * 
     */
    public void setCustomerAge(int value) {
        this.customerAge = value;
    }

    /**
     * Gets the value of the customerGender property.
     * 
     */
    public int getCustomerGender() {
        return customerGender;
    }

    /**
     * Sets the value of the customerGender property.
     * 
     */
    public void setCustomerGender(int value) {
        this.customerGender = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     */
    public double getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     */
    public void setCustomerId(double value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the customerLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerLastname() {
        return customerLastname;
    }

    /**
     * Sets the value of the customerLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerLastname(String value) {
        this.customerLastname = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

}
