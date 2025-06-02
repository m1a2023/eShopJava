package com.ecom.shop.DTO;

import lombok.Getter;

@Getter public abstract class Product {

	public Product() {}

	public Product(String title, Integer quantity) {
		this.title = title;
		this.quantity = quantity;
	}	

	protected String title;
	protected Integer quantity; 
}
