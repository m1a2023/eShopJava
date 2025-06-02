package com.ecom.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.shop.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> { 

	@NativeQuery("SELECT * FROM products;")
	@Override List<ProductModel> findAll();

	@Modifying @Transactional
	@NativeQuery("UPDATE products SET quantity=?2, is_bought=?3 where title=?1")
	Integer update(String title, Integer quantity, Boolean isBought);

	@Modifying @Transactional
	@NativeQuery("DELETE FROM products where title=?1") 
	Integer delete(String title);
}
