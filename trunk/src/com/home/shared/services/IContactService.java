package com.home.shared.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.home.shared.entities.ContactDetails;

@RemoteServiceRelativePath("contact.rpc")
public interface IContactService extends RemoteService {

	boolean addContact(ContactDetails contact);
	boolean update(ContactDetails contact);
	boolean deleteContact(int contactId);
	ContactDetails findContact(int contactId);
	List<ContactDetails> getAllContacts();
}
