package com.home.server.dao;

import java.util.List;

import com.home.server.entities.Contacts;

public interface ContactsDao extends GenericDao<Contacts> {

	public List<Contacts> getAllContacts();
}
