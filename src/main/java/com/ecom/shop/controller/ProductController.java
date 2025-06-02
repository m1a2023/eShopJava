package com.ecom.shop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.shop.DTO.ProductDTO;
import com.ecom.shop.DTO.ProductInsertionDTO;
import com.ecom.shop.DTO.ProductUpdateDTO;
import com.ecom.shop.model.ProductModel;
import com.ecom.shop.service.ProductService;
import com.ecom.shop.utils.Response.ChangedRowsQuantity;
import com.ecom.shop.utils.Response.ResponseId;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller @RequestMapping("/products")
public class ProductController {
	
	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/batch/all")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		var products = service.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseId> 
	createProduct(@RequestBody ProductInsertionDTO product) {
		var create = new ProductModel(product.getTitle(), product.getQuantity());
		var id = service.createProduct(create);
		var response = new ResponseId(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update")
	public ResponseEntity<ChangedRowsQuantity>	
	updateProduct(@RequestBody ProductUpdateDTO product) {
		var id = service.updateProduct(product);
		var response = new ChangedRowsQuantity(id);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/") 
	public ResponseEntity<ChangedRowsQuantity>
	deleteProduct(@RequestParam String title) {
		var id = service.deleteProduct(title);
		var response = new ChangedRowsQuantity(id);
		return ResponseEntity.ok(response);
	}
}
