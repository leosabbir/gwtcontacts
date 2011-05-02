package com.home.server.service;

import java.util.List;

import com.home.server.entities.ContactDetailsEntity;
import com.home.server.entities.Contacts;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;


public interface IContactsService {
	public boolean saveContact(ContactDetails contact);
    
	public boolean updateContact(ContactDetails test);
    
	public boolean deleteContact(int id);
   
    public List<ContactNameId> getAllContacts();
    public ContactDetails findContact(int code);
}
