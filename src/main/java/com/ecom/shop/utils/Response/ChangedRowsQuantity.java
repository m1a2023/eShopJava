package com.ecom.shop.utils.Response;

import lombok.Getter;

@Getter public class ChangedRowsQuantity {

	private final Integer quantity;

	public ChangedRowsQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
