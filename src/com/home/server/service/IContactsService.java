package com.home.server.service;

import java.util.List;

import com.home.server.entities.ContactDetailsEntity;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;


public interface IContactsService {
	public boolean save(ContactDetails test);
    public boolean update(ContactDetails test);
    public boolean delete(int id);
    public List<ContactNameId> getAllContacts();
    public ContactDetails findContact(int code);
}
