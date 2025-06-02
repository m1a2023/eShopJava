package com.ecom.shop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.shop.model.UserModel;
import com.ecom.shop.service.UserService;
import com.ecom.shop.utils.Response.ResponseId;


@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@Controller
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	} 

	@GetMapping("/users") 
	public ResponseEntity<List<UserModel>> getAllUsers() {
		List<UserModel> users = userService.getAllUsers(); 
		return ResponseEntity.ok(users);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserModel> getUserById(@PathVariable String id) {
		UserModel u = userService.getUserById(id);
		return ResponseEntity.ok(u);
	}

	@GetMapping("/user/")
	public ResponseEntity<UserModel> getUserByEmail(@RequestParam String email) {
		UserModel u = userService.getUserByEmail(email);
		return ResponseEntity.ok(u);
	}

	@PostMapping("/user")
	public ResponseEntity<ResponseId> createUser(@RequestBody UserModel u) {
		String id = userService.createUser(u);
		ResponseId res = new ResponseId(id);
		return ResponseEntity.ok(res);
	}

	/* TODO: DELETE, PUT methods */

}
