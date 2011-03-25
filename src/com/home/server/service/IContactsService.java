package com.home.server.service;

import java.util.List;

import com.home.shared.entities.ContactDetails;


public interface IContactsService {
	public boolean save(ContactDetails test);
    public boolean update(ContactDetails test);
    public boolean delete(int id);
    public List<ContactDetails> getAllContacts();
    public ContactDetails findByProductCode(int code);
}
