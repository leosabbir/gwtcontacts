package com.home.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.IContactsDao;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.entities.Contacts;
import com.home.server.entities.Principal;
import com.home.server.entities.UserContacts;

@Repository
public class ContactsDao implements IContactsDao{

	private HibernateTemplate hibernateTemplate;

    public ContactsDao(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	@Transactional
	public List<Contacts> getAllContacts() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		//parameters.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Principal> principals = hibernateTemplate.find("from Principal where username = ?", new Object[]{name});
		String emailId = principals.get(0).getEmailId();
		//parameters.put("emailid", emailId);
		return hibernateTemplate.find("from Contacts where emailid = ?", emailId);
		
	}

	@Override
	public boolean saveContact(Contacts contact) {
		this.hibernateTemplate.save(contact);
		return true;
	}

	@Override
	public boolean savePrincipal(Principal principal) {
		this.hibernateTemplate.save(principal);
		return true;
	}

	@Override
	public boolean saveUserContact(UserContacts userContact) {
		this.hibernateTemplate.save(userContact);
		return true;
	}

	@Override
	public boolean updateContact(Contacts contact) {
		this.hibernateTemplate.saveOrUpdate(contact);
		return true;
	}

	@Override
	public boolean updatePrincipal(Principal principal) {
		this.hibernateTemplate.saveOrUpdate(principal);
		return true;
	}

	@Override
	public boolean updateUserContact(UserContacts userContact) {
		this.hibernateTemplate.saveOrUpdate(userContact);
		return true;
	}

	@Override
	public boolean deleteContact(Contacts contact) {
		this.hibernateTemplate.delete(contact);
		return true;
	}

	@Override
	public boolean deletePrincipal(Principal principal) {
		this.hibernateTemplate.delete(principal);
		return true;
	}

	@Override
	public boolean deleteUserContact(UserContacts userContact) {
		this.hibernateTemplate.delete(userContact);
		return true;
	}

	@Override
	public UserContacts findUserContact(int usesrContactId) {
		UserContacts userContact = this.hibernateTemplate.get(UserContacts.class, usesrContactId);
		return userContact;
	}

	@Override
	public Principal findPrincipal(String username) {
		Principal principal = this.hibernateTemplate.get(Principal.class, username);
		return principal;
	}

	@Override
	public Contacts findContact(int contactId) {
		Contacts contact = this.hibernateTemplate.get(Contacts.class, contactId);
		return contact;
	}

	@Override
	public Principal findPrincipalByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
