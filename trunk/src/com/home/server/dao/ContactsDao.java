package com.home.server.dao;

import java.util.List;
import java.util.Set;

import com.home.server.entities.Contacts;

public interface ContactsDao extends GenericDao<Contacts> {

	public Set<Contacts> getAllContacts();
}
