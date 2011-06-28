package com.home.shared.services;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;
import com.home.server.dao.impl.ContactsDaoImpl;
import com.home.server.service.impl.ContactsServiceLocator;
import com.home.shared.proxy.ContactsProxy;


@Service( value = ContactsDaoImpl.class, locator = ContactsServiceLocator.class)
public interface ContactDetailsRequest extends RequestContext {
	
	Request<ContactsProxy> findContact(int contactId);

}
