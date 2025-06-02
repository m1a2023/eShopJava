package com.ecom.shop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecom.shop.DTO.ProductDTO;
import com.ecom.shop.DTO.ProductUpdateDTO;
import com.ecom.shop.model.ProductModel;
import com.ecom.shop.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	} 

	public List<ProductDTO> getAllProducts() {
		var res = repository.findAll();
		var products = res.stream()
												.map((p) -> new ProductDTO(p))
												.collect(Collectors.toList());
		return products;
	}

	public Integer createProduct(ProductModel product) {
		var p = repository.save(product);
		return p.getId();
	}

	public Integer updateProduct(ProductUpdateDTO product) {
		var q = repository.update(
			product.getTitle(), product.getQuantity(), product.getIsBought());
		return q;
	}

	public Integer deleteProduct(String title) {
		var q = repository.delete(title);
		return q;
	}
}
