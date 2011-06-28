package com.home.server.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.requestfactory.shared.Locator;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.entities.Contacts;
import com.home.shared.entities.ContactDetails;

public class ContactDetailsLocator extends Locator<ContactDetailsEntity, Long> {

	@Override
	public ContactDetailsEntity create(
			Class<? extends ContactDetailsEntity> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDetailsEntity find(
			Class<? extends ContactDetailsEntity> clazz, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<ContactDetailsEntity> getDomainType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getId(ContactDetailsEntity domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Long> getIdType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVersion(ContactDetailsEntity domainObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public static ContactDetailsEntity getContactDetails(int userId) {
		ContactDetailsEntity contactDetails = new ContactDetailsEntity();
		
		contactDetails.setName("Test");
		contactDetails.setAddress("testAddress");
		contactDetails.setMobile("testMobile");
		contactDetails.setUserId(25);
		
		return contactDetails; 
	}

}
