package com.cookiesandcream.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "product_name")
	private String productName;
	
	@Column(name= "product_code")
	private String productCode;
	
	@Column(name= "product_Quantity")
	private int productQuantity;
	
	@Column(name= "product_price")
	private double productPrice;
	
	
	
	public Product(String productName, String productCode, int productQuantity, double productPrice) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
