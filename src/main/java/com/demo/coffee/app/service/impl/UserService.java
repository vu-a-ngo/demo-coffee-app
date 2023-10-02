package com.demo.coffee.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.coffee.app.dto.UserDto;
import com.demo.coffee.app.jpa.entity.User;
import com.demo.coffee.app.jpa.repository.UserRepository;
import com.demo.coffee.app.service.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	private PasswordEncoder passwordEncoder;

	private UserRepository userRepository;

	public UserService(final PasswordEncoder passwordEncoder, final UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	@Override
	public void saveUser(final UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getUsername()));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPhoneNumber(userDto.getPhoneNumber());

		userRepository.save(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();

		return users.stream().map(u -> toUserDto(u)).collect(Collectors.toList());
	}

	private UserDto toUserDto(final User user) {
		if (user == null) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setUsername(user.getUsername());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setRole(user.getRole());
		return dto;
	}

	@Override
	public UserDto getUserByUsername(final String username) {
		return toUserDto(userRepository.findByUsername(username).orElse(null));
	}

	@Override
	public UserDto getUserByPhoneNumber(final String phoneNumber) {
		return toUserDto(userRepository.findByPhoneNumber(phoneNumber).orElse(null));
	}

}
