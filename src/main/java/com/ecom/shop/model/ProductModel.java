package com.ecom.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
public class ProductModel {
	
	public ProductModel() { }
	public ProductModel(String title, Integer quantity) {
		this.title = title;
		this.quantity = quantity;
		this.isBought = false;
	}
	public ProductModel(String title, Integer quantity, Boolean isBought) {
		this.title = title;
		this.quantity = quantity;
		this.isBought = isBought;
	}
	public ProductModel(Integer id, String title, Integer quantity, Boolean isBought) {
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.isBought = isBought;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Getter @Setter private Integer id;

	@Getter @Setter private String title;

	@Getter @Setter private Integer quantity;

	@Getter @Setter private Boolean isBought;
}
