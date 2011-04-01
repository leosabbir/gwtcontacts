package com.home.server.dao;

import java.util.List;

import com.home.server.entities.ContactDetailsEntity;

public interface IContactsDao {
	public boolean save(ContactDetailsEntity test);
    public boolean update(ContactDetailsEntity test);
    public boolean delete(ContactDetailsEntity test);
    public List<ContactDetailsEntity> getAllContacts();
    public ContactDetailsEntity findContact(int code);
}
