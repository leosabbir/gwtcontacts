package com.home.server.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.requestfactory.shared.Locator;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.entities.Contacts;

public class ContactDetailsLocator extends Locator<Contacts, Long> {
	
	
	
	@Transactional
	public static ContactDetailsEntity getContactDetails(int userId) {
		ContactDetailsEntity contactDetails = new ContactDetailsEntity();
//		Contacts contact = contactDao.find(userId);
//		
//		contactDetails.setName(contact.getFirstName());
//		contactDetails.setAddress(contact.getAddress());
//		contactDetails.setMobile(contact.getMobile());
		
		return contactDetails; 
	}

	@Override
	public Contacts create(Class<? extends Contacts> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contacts find(Class<? extends Contacts> clazz, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Contacts> getDomainType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getId(Contacts domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Long> getIdType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVersion(Contacts domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
