package com.ecom.shop.DTO;

import com.ecom.shop.model.ProductModel;

import lombok.Getter;

@Getter public class ProductDTO extends Product {

	public ProductDTO(ProductModel model) {
		super(model.getTitle(), model.getQuantity());

		this.id = model.getId();
		this.isBought = model.getIsBought();
	}

	private final Integer id;
	private	final Boolean isBought;
}
