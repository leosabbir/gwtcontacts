package com.home.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.home.client.view.ClientFactory;
import com.home.client.view.IMainView;
import com.home.client.view.SettingsView;
import com.home.shared.services.ContactsRequestFactory;

public class ClientFactoryImpl implements ClientFactory {

	private final EventBus eventBus;
	private final PlaceController placeController;
	private final ContactsRequestFactory requestFactory;
	private IMainView mainView;
	private SettingsView settingsView;
	
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
		requestFactory = GWT.create(ContactsRequestFactory.class);
		requestFactory.initialize(eventBus);
	}
	
	@Override
	public EventBus getEventBus() {
		return this.eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return this.placeController;
	}

	@Override
	public IMainView getMainView() {
		if( mainView == null){
			mainView = new MainView();
		}
		return mainView;
	}

	@Override
	public SettingsView getSettingsView() {
		if( settingsView == null){
			settingsView = new SettingsViewImpl();
		}
		return settingsView;
	}

	@Override
	public ContactsRequestFactory getRequestFactory() {
		return this.requestFactory;
	}

}
