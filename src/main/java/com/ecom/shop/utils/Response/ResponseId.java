package com.ecom.shop.utils.Response;

import lombok.Getter;

@Getter public class ResponseId {
	private final Integer id;
	public ResponseId(String id) {
		this.id = Integer.decode(id);
	}

	public ResponseId(Integer id) {
		this.id = id;
	}
} 
