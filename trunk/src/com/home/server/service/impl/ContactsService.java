package com.home.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.ContactsDao;
import com.home.server.dao.GenericDao;
import com.home.server.dao.IContactsDao;
import com.home.server.dao.PrincpalDao;
import com.home.server.dao.UserContactsDao;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.entities.Contacts;
import com.home.server.entities.Principal;
import com.home.server.service.IContactsService;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;

@Service
public class ContactsService implements IContactsService {

	@Autowired
	ContactsDao contactDao;
	
	@Autowired
	PrincpalDao principalDao;
	
	@Autowired
	UserContactsDao userContactsDao;
	
	
	public ContactsService(){
		
	}
	
	public ContactsService(ContactsDao contactDao){
		this.contactDao = contactDao;
	}
	
	@Override
	@Transactional
	public boolean deleteContact(int id) {
//		Contacts contact = this.contactDao.findContact(id);
//		if(contact != null){
//			return this.contactDao.deleteContact(contact);
//		}
		return false;
	}

	@Override
	@Transactional
	public ContactDetails findContact(int userId) {
		ContactDetails contactDetails = new ContactDetails();
		Contacts contacts = this.contactDao.find(userId);
		
		contactDetails.setFirstName(contacts.getFirstName());
		contactDetails.setAddress(contacts.getAddress());
		contactDetails.setMobile(contacts.getMobile());
		contactDetails.setUserid(userId);
		
		return contactDetails; 
	}

	@Override
	@Transactional
	public boolean saveContact(ContactDetails contactDetails) {
		Contacts contacts = new Contacts();
		
		Principal principal = this.principalDao.find(SecurityContextHolder.getContext().getAuthentication().getName());
		
		contacts.setFirstName(contactDetails.getFirstName());
		contacts.setMiddleName(contactDetails.getMiddleName());
		contacts.setLastName(contactDetails.getLastName());
		contacts.setAddress(contactDetails.getAddress());
		contacts.setMobile(contactDetails.getMobile());
		contacts.setEmailId(contactDetails.getEmailId());
		//SecurityContextHolder.getContext().getAuthentication().
		return this.contactDao.save(contacts);
	}

	@Override
	public boolean updateContact(ContactDetails test) {
//		Contacts updated = this.contactDao.findContact(test.getUserid());
//		updated.setAddress(test.getAddress());
//		return this.contactDao.updateContact(updated);
		return false;
		
	}

	@Override
	public List<ContactNameId> getAllContacts() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		ContactNameId contact;
		List<ContactNameId> contactDetailList = new ArrayList<ContactNameId>();
		
		for(Contacts contacts : this.contactDao.getAllContacts()){
			contact = new ContactNameId();
			contact.setName(contacts.getFirstName());
			contact.setUserid(contacts.getContactId());
			
			contactDetailList.add(contact);
		}
		return contactDetailList;
	}

}
