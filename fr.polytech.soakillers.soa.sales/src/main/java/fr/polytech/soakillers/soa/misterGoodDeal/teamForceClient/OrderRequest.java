
package fr.polytech.soakillers.soa.misterGoodDeal.teamForceClient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="treated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="products_id" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="order_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="order_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderRequest", propOrder = {
    "accountId",
    "treated",
    "productsId",
    "orderDate",
    "orderId"
})
public class OrderRequest {

    @XmlElement(name = "account_id")
    protected int accountId;
    protected boolean treated;
    @XmlElement(name = "products_id", type = Double.class)
    protected List<Double> productsId;
    @XmlElement(name = "order_date", required = true)
    protected String orderDate;
    @XmlElement(name = "order_id")
    protected int orderId;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(int value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the treated property.
     * This getter has been renamed from isTreated() to getTreated() by cxf-xjc-boolean plugin.
     * 
     */
    public boolean getTreated() {
        return treated;
    }

    /**
     * Sets the value of the treated property.
     * 
     */
    public void setTreated(boolean value) {
        this.treated = value;
    }

    /**
     * Gets the value of the productsId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productsId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductsId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getProductsId() {
        if (productsId == null) {
            productsId = new ArrayList<Double>();
        }
        return this.productsId;
    }

    /**
     * Gets the value of the orderDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDate(String value) {
        this.orderDate = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     */
    public void setOrderId(int value) {
        this.orderId = value;
    }

    /**
     * Sets the value of the productsId property.
     * 
     * @param productsId
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setProductsId(List<Double> productsId) {
        this.productsId = productsId;
    }

}
