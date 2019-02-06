package com.food.order.catalogue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="ProductID")
	private Integer productId;
	@Column(name="ProductName")
	private String productName;
	@Column(name="ProductDescription")
	private String productDescription;
	@Column(name="ProductPrice")
	private Double productPrice;

	public Product() {
		// Auto-generated constructor stub
	}
	
	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

}
