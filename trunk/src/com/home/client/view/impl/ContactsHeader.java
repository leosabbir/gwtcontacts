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

public class ContactsHeader extends Composite{

	private static ContactsHeaderUiBinder uiBinder = GWT
			.create(ContactsHeaderUiBinder.class);

	interface ContactsHeaderUiBinder extends UiBinder<Widget, ContactsHeader> {
	}

	public ContactsHeader() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ContactsHeader(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
