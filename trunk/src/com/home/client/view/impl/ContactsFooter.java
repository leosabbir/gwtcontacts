package com.home.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.view.IContactsFooter;

public class ContactsFooter extends Composite implements IContactsFooter{

	private static ContactsFooterUiBinder uiBinder = GWT
			.create(ContactsFooterUiBinder.class);

	interface ContactsFooterUiBinder extends UiBinder<Widget, ContactsFooter> {
	}

	public ContactsFooter() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ContactsFooter(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
