package com.home.client.view;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.home.shared.services.ContactsRequestFactory;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	ContactsRequestFactory getRequestFactory();
	
	IMainView getMainView();
	SettingsView getSettingsView();

}
