package com.home.server.dao;

import java.util.List;

import com.home.shared.entities.ContactDetails;

public interface ITestDao {
	public boolean save(ContactDetails test);
    public boolean update(ContactDetails test);
    public boolean delete(ContactDetails test);
    public List<ContactDetails> getAllContacts();
    public ContactDetails findByProductCode(int code);
}
