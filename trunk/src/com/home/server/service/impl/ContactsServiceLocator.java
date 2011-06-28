package com.home.server.service.impl;

import org.springframework.beans.BeansException;
import com.google.gwt.requestfactory.shared.ServiceLocator;

public class ContactsServiceLocator implements ServiceLocator {

	@Override
	public Object getInstance(Class<?> clazz) {
		try {
		      return ApplicationContextProvider.getApplicationContext().getBean(clazz);
		    } catch (BeansException e){
		    	return null;
		    }

	}

}
