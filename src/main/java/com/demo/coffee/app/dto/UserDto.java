package com.demo.coffee.app.dto;

import java.io.Serializable;

import com.demo.coffee.app.jpa.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable {

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private String address;

	private String phoneNumber;

	private User.Role role;
}
