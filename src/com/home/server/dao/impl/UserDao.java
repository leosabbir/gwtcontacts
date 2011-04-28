package com.home.server.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;

import com.home.server.dao.IUserDao;
import com.home.server.entities.UserDetails;

@Repository
@Transactional(rollbackFor = Throwable.class)
public class UserDao implements IUserDao {

	@Autowired
	private HibernateTemplate dao;

	public void store(User user) {
		dao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails findUserByName(String userName) {
		return (UserDetails)dao.find("select u from User u where name = ?1", userName).get(0);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails findUserByEmailAddress(String emailAddress) {
		return (UserDetails)dao.find("select u from User u where u.emailAddress=?1", emailAddress).get(0);
	}
}