package com.sporty_shoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty_shoes.entities.User;
import com.sporty_shoes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;

	@Override
	public User addUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(long userId) {
		return userDao.findById(userId).get();
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findByName(String name) {
		return userDao.findByName(name);
	}

}
