package com.home.server.dao;

import org.springframework.security.core.userdetails.User;

import com.home.server.entities.UserDetails;


public interface IUserDao {
	void store(User user);

	UserDetails findUserByEmailAddress(String emailAddress);

	UserDetails findUserByName(String userName);
}
