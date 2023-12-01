package com.stackroute.springdatajpamysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Product {
    //Add Product entity fields, constructors and getters/setters here
	@Id
	private Long productId;
	@Column
	private String name;
	@Column
	private double price;
	
	
	public Product(){
		
	}
	

	public Product(Long productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	

	
	

}
