package com.ecom.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.shop.model.UserModel;
import com.ecom.shop.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserModel> getAllUsers() {
		return this.userRepository.findAll();
	}

	public UserModel getUserById(String id) {
		Integer _id = Integer.decode(id);
		return this.userRepository.findById(_id).orElse(null);
	} 

	public UserModel getUserByEmail(String email) {
		return this.userRepository.findByEmail(email).orElse(null);
	}

	public String createUser(UserModel user) {
		UserModel u = this.userRepository.save(user);
		String id = u.getId().toString();
		return id;
	}

	/* TODO: DELETE, PUT methods */
}
