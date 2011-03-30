package com.home.client.services;

import com.google.gwt.core.client.GWT;
import com.home.shared.services.IContactService;
import com.home.shared.services.IContactServiceAsync;

public class ServiceProvider {
	
	private final IContactServiceAsync contactService;

	private static ServiceProvider _instance;

	private ServiceProvider() {
		this.contactService = GWT.create(IContactService.class);
	}
	
	public static ServiceProvider getInstance() {
		if (_instance == null) {
			_instance = new ServiceProvider();
		}
		return _instance;
	}
	
	public IContactServiceAsync getContactService() {
		return this.contactService;
	}

}
