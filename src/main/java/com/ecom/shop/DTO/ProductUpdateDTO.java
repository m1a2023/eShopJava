package com.ecom.shop.DTO;

import lombok.Getter;

@Getter public class ProductUpdateDTO extends Product {

	public ProductUpdateDTO(String title, Integer quantity, Boolean isBought) {
		super(title, quantity);
		this.isBought = isBought;
	}

	private final Boolean isBought;
}
