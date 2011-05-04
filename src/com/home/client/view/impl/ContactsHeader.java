package com.home.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.asm.commons.Method;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.places.SettingsPlace;

public class ContactsHeader extends Composite{

	private static ContactsHeaderUiBinder uiBinder = GWT
			.create(ContactsHeaderUiBinder.class);

	interface ContactsHeaderUiBinder extends UiBinder<Widget, ContactsHeader> {
	}

	
	@UiField
	Anchor settingsTest;
	
	@UiField
	FileUpload fileUpload;
	
	@UiField
	FormPanel form;
	
	private PlaceController placeController;
	
	public void setPlaceController(PlaceController placeController){
		this.placeController = placeController;
		form.setMethod(FormPanel.METHOD_POST);
		form.setAction("/upload/sabbir");
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		
		fileUpload.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				form.submit();
				
			}
		});
	}
	
	public ContactsHeader() {
		initWidget(uiBinder.createAndBindUi(this));
		settingsTest.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				placeController.goTo(new SettingsPlace("settings"));
				
			}
		});
	}

}
