package com.home.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.home.client.mvp.ContactsActivityMapper;
import com.home.client.mvp.ContactsPlaceHistoryMapper;
import com.home.client.places.MainPlace;
import com.home.client.resources.ContactsCssResource;
import com.home.client.resources.ContactsResources;
import com.home.client.view.ClientFactory;
import com.home.client.view.impl.ContactsHeader;

public class ControllerApp implements EntryPoint {

	interface ControllerAppUiBinder extends UiBinder<HTMLPanel, ControllerApp> {
	}
	
	private static ControllerAppUiBinder uiBinder = GWT.create(ControllerAppUiBinder.class);

	@UiField
	SimplePanel centerContainer;
	
	@UiField
	ContactsHeader contactsHeader;

	private Panel application;
	
	@Override
	public void onModuleLoad() {
		ContactsResources.INSTANCE.contactsCss().ensureInjected();
		
		this.application = uiBinder.createAndBindUi(this);
		RootPanel.get().add(application);
		
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		final PlaceController placeController = clientFactory.getPlaceController();
		// start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new ContactsActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(centerContainer);

		contactsHeader.setPlaceController(clientFactory.getPlaceController());
		
		// start PlaceHistoryHandler with our PlaceHistoryMapper
		ContactsPlaceHistoryMapper historyMapper = GWT.create(ContactsPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, new MainPlace("mainplace"));

		historyHandler.handleCurrentHistory();
	}
}
