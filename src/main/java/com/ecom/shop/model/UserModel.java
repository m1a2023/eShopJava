package com.ecom.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class UserModel {

	public UserModel() { }

	public UserModel(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Getter
	private Integer id;

	@Getter @Setter private String name;

	@Getter @Setter private String password;

	@Getter @Setter private String email;

}
