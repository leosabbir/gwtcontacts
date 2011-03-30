package com.home.client.view.impl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.home.client.view.ClientFactory;
import com.home.client.view.IMainView;

public class ClientFactoryImpl implements ClientFactory {

	private final EventBus eventBus;
	private final PlaceController placeController;
	private IMainView mainView;
	
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
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

}
