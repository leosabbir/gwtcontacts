package com.home.client.view.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.home.shared.entities.ContactDetails;

public class ContactDetailsView extends Composite {

	private static ContactDetailsViewUiBinder uiBinder = GWT
			.create(ContactDetailsViewUiBinder.class);

	interface ContactDetailsViewUiBinder extends
			UiBinder<Widget, ContactDetailsView> {
	}
	
	@UiField
	Label nameField;
	
	@UiField
	Label addressField;
	
	@UiField
	Label mobileField;

	public ContactDetailsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setData(ContactDetails contactDetails){
		this.nameField.setText(contactDetails.getName());
		this.addressField.setText(contactDetails.getAddress());
		this.mobileField.setText(contactDetails.getMobile());
	}

}
