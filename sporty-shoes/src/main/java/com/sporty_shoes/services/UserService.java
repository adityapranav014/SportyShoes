package com.sporty_shoes.services;

import java.util.List;

import com.sporty_shoes.entities.User;

public interface UserService {

	public User addUser(User user);

	public List<User> getAllUsers();

	public User getUserById(long userId);

	public User findByEmail(String email);

	public List<User> findByName(String name);

}
