package com.home.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;

import com.home.server.dao.ContactsDao;
import com.home.server.entities.Contacts;
import com.home.server.entities.Principal;

public class ContactsDaoImpl extends GenericDaoImpl<Contacts> implements ContactsDao {

	@Override
	public Set<Contacts> getAllContacts() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Principal> principals = getHibernateTemplate().find("from Principal where username = ?", new Object[]{name});
		String emailId = principals.get(0).getEmailId();
		return principals.get(0).getContacts();//getHibernateTemplate().find("from Contacts where emailid = ?", emailId);
	}
	
	public Contacts findContact(int userId){
		return this.find(userId);
	}

}
