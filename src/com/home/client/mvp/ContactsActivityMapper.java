package com.home.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.home.client.activities.MainActivity;
import com.home.client.activities.SettingsActivity;
import com.home.client.places.MainPlace;
import com.home.client.places.SettingsPlace;
import com.home.client.view.ClientFactory;

public class ContactsActivityMapper implements ActivityMapper {
	
	private final ClientFactory clientFactory;
	
	public ContactsActivityMapper(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MainPlace) {
			MainPlace mainPlace = (MainPlace) place;
			//clientFactory.getNavigationalPanel().monitoringSelected();
			return new MainActivity(clientFactory.getMainView());
		}else if(place instanceof SettingsPlace){
			SettingsPlace settingsPlace = (SettingsPlace) place;
			return new SettingsActivity(clientFactory.getSettingsView());
		}
		return null;
	}

}
