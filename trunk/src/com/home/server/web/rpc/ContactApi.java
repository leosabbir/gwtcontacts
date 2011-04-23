package com.home.server.web.rpc;

import java.util.List;

import com.home.server.entities.ContactDetailsEntity;
import com.home.server.service.IContactsService;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;
import com.home.shared.services.IContactService;

public class ContactApi implements IContactService {

	private final IContactsService contactsService;
	
	public ContactApi(IContactsService contactsService){
		this.contactsService = contactsService;
	}
	
	@Override
	public boolean addContact(ContactDetails contact) {
		return contactsService.save(contact);
	}

	@Override
	public boolean deleteContact(int contactId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContactDetails findContact(int contactId) {
		ContactDetails detail = contactsService.findContact(contactId);
		return detail;
	}

	@Override
	public List<ContactNameId> getAllContacts() {
		List<ContactNameId> details = contactsService.getAllContacts(); 
		return details;
	}

	@Override
	public boolean update(ContactDetails contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContactDetails getContact(int contactId) {
		ContactDetails test = new ContactDetails();
		ContactDetails contact = contactsService.findContact(contactId);
		test.setAddress(contact.getAddress());
		test.setMobile(contact.getMobile());
		test.setName(contact.getName());
		test.setUserid(contact.getUserid());
		return test;
	}

}
