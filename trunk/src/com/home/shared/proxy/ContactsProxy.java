package com.home.shared.proxy;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.entities.Contacts;
import com.home.server.service.impl.ContactDetailsLocator;


@ProxyFor( value = Contacts.class, locator = ContactDetailsLocator.class)
public interface ContactsProxy extends EntityProxy {

	int getContactId();
	
	String getEmailId();
	
	String getFirstName();
	
	String getMiddleName();
	
	String getLastName();
	
	String getMobile();
	
	String getAddress();
	
	void setContactId(int userId);
	
	void setEmailId(String emailId);
	
	void setFirstName(String name);
	
	void setMiddleName(String name);
	
	void setLastName(String name);
	
	void setMobile(String mobile);
	
	void setAddress(String address);
}
