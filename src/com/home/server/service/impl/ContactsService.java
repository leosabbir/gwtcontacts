package com.home.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.server.dao.IContactsDao;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.service.IContactsService;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;

@Service
public class ContactsService implements IContactsService {

	@Autowired
	IContactsDao contactDao;
	
	public ContactsService(IContactsDao contactDao){
		this.contactDao = contactDao;
		//System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		ContactDetailsEntity test = this.contactDao.findContact(id);
		if(test != null){
			return this.contactDao.delete(test);
		}
		return false;
	}

	@Override
	@Transactional
	public ContactDetails findContact(int userId) {
		ContactDetails contactDetails = new ContactDetails();
		ContactDetailsEntity contactDetailsEntity = this.contactDao.findContact(userId);
		
		contactDetails.setName(contactDetailsEntity.getName());
		contactDetails.setAddress(contactDetailsEntity.getAddress());
		contactDetails.setMobile(contactDetailsEntity.getMobile());
		contactDetails.setUserid(userId);
		
		return contactDetails; 
	}

	@Override
	@Transactional
	public boolean save(ContactDetails contactDetails) {
		ContactDetailsEntity contactDetailsEntity = new ContactDetailsEntity();
		
		contactDetailsEntity.setName(contactDetails.getName());
		contactDetailsEntity.setAddress(contactDetails.getAddress());
		contactDetailsEntity.setMobile(contactDetails.getMobile());
		
		return this.contactDao.save(contactDetailsEntity);
	}

	@Override
	public boolean update(ContactDetails test) {
		ContactDetailsEntity updated = this.contactDao.findContact(test.getUserid());
		updated.setAddress(test.getAddress());
		return this.contactDao.update(updated);
		
	}

	@Override
	public List<ContactNameId> getAllContacts() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		ContactNameId contact;
		List<ContactNameId> contactDetailList = new ArrayList<ContactNameId>();
		
		for(ContactDetailsEntity contactDetailsEntity : this.contactDao.getAllContacts()){
			contact = new ContactNameId();
			contact.setName(contactDetailsEntity.getName());
			contact.setUserid(contactDetailsEntity.getId());
			
			contactDetailList.add(contact);
		}
		return contactDetailList;
	}

}
