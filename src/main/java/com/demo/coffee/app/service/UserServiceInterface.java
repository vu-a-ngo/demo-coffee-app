package com.demo.coffee.app.service;

import java.util.List;

import com.demo.coffee.app.dto.UserDto;

public interface UserServiceInterface {

	void saveUser(UserDto userDto);

	List<UserDto> getAllUsers();

	UserDto getUserByUsername(String username);

	UserDto getUserByPhoneNumber(String phoneNumber);
}
