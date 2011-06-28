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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.view.IMainView.Presenter;
import com.home.shared.entities.ContactDetails;

public class AddContact extends Composite {

	private static AddContactUiBinder uiBinder = GWT
			.create(AddContactUiBinder.class);

	interface AddContactUiBinder extends UiBinder<Widget, AddContact> {
	}
	
	Presenter presenter;
	
	@UiField
	TextBox firstNameInput;
	
	@UiField
	TextBox middleNameInput;
	
	@UiField
	TextBox lastNameInput;
	
	@UiField
	TextBox addressInput;
	
	@UiField
	TextBox mobileInput;
	
	@UiField
	TextBox emailIdInput;
	
	@UiField
	Button saveContactBtn;

	public AddContact() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setPresenter(Presenter presenter){
		this.presenter = presenter;
	}
	
	@UiHandler("saveContactBtn")
	void addContactBtnClicked(ClickEvent event){
		ContactDetails contactDetails = new ContactDetails();
		
		contactDetails.setFirstName( this.firstNameInput.getText());
		contactDetails.setMiddleName(this.middleNameInput.getText());
		contactDetails.setLastName(this.lastNameInput.getText());
		contactDetails.setAddress(this.addressInput.getText());
		contactDetails.setMobile(this.mobileInput.getText());
		contactDetails.setEmailId(this.emailIdInput.getText());
		
		this.presenter.saveContact(contactDetails);
	}

}
