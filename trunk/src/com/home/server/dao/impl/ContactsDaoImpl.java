package com.home.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import com.home.server.dao.ContactsDao;
import com.home.server.entities.Contacts;
import com.home.server.entities.Principal;

public class ContactsDaoImpl extends GenericDaoImpl<Contacts> implements ContactsDao {

	@Override
	public List<Contacts> getAllContacts() {
		//return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from test").list();
		Map<String, Object> parameters = new HashMap<String, Object>();
		//parameters.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Principal> principals = getHibernateTemplate().find("from Principal where username = ?", new Object[]{name});
		String emailId = principals.get(0).getEmailId();
		//parameters.put("emailid", emailId);
		return getHibernateTemplate().find("from Contacts where emailid = ?", emailId);
	}

}
