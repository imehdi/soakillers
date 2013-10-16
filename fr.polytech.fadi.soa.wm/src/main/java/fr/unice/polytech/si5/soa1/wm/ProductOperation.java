package fr.unice.polytech.si5.soa1.wm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductOperation {

	private long id;
	private String company;
	private Product product;
	private Boolean consume;
	private int quantity;
	private Date orderDate;

	public ProductOperation() {
	}

	public ProductOperation(long id, String company, Product product, 
			Boolean consume, int quantity, String orderDate) throws ParseException {
		this.id = id;
        this.company = company;
        this.product = product;
        this.consume = consume;
        this.quantity = quantity;
        this.orderDate = new SimpleDateFormat("H:m,dd/MM/yyyy").parse(orderDate);
        
        if(consume){
        	product.setUnitsInStock(product.getUnitsInStock() - quantity);
        } else {
        	product.setUnitsInStock(product.getUnitsInStock() + quantity);
        }
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean getConsume() {
		return consume;
	}

	public void setConsume(Boolean consume) {
		this.consume = consume;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toJson() {
		String json = "{ \"id\":\"" + id + "\" , " 
	            + "\"company\":\"" + company + "\" , " 
				+ "\"productId\":\"" + product.getId() + "\" , "
				+ "\"consume\":\"" + consume.toString() + "\" , "
				+ "\"quantity\":\"" + quantity + "\" , "
				+ "\"date\":\"" + orderDate.toString() + "\" }";

		return json;
	}
}