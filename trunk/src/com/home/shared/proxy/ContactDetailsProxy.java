package com.home.shared.proxy;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.service.impl.ContactDetailsLocator;


@ProxyFor( value = ContactDetailsEntity.class, locator = ContactDetailsLocator.class)
public interface ContactDetailsProxy extends EntityProxy {

	Integer getUserId();
	
	String getEmailId();
	
	String getName();
	
	String getMobile();
	
	String getAddress();
	
	void setUserId(Integer userId);
	
	void setEmailId(String emailId);
	
	void setName(String name);
	
	void setMobile(String mobile);
	
	void setAddress(String address);
}
