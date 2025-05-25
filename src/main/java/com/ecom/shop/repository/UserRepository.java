package com.ecom.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.shop.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	@Override Optional<UserModel> findById(Integer id);

	Optional<UserModel> findByEmail(String email);
}
