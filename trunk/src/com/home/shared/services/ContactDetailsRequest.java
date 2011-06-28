package com.home.shared.services;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;
import com.home.server.entities.ContactDetailsEntity;
import com.home.server.service.impl.ContactDetailsLocator;
import com.home.shared.proxy.ContactDetailsProxy;


@Service(ContactDetailsLocator.class)
public interface ContactDetailsRequest extends RequestContext {
	
	Request<ContactDetailsProxy> getContactDetails(int contactId);

}
