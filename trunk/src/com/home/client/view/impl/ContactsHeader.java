package com.home.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.places.SettingsPlace;

public class ContactsHeader extends Composite{

	private static ContactsHeaderUiBinder uiBinder = GWT
			.create(ContactsHeaderUiBinder.class);

	interface ContactsHeaderUiBinder extends UiBinder<Widget, ContactsHeader> {
	}

	
	@UiField
	Anchor test;
	
	private PlaceController placeController;
	
	public void setPlaceController(PlaceController placeController){
		this.placeController = placeController;
	}
	
	public ContactsHeader() {
		initWidget(uiBinder.createAndBindUi(this));
		test.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				placeController.goTo(new SettingsPlace("settings"));
				
			}
		});
	}

}
