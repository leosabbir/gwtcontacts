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

public class SelfView extends Composite {

	private static SelfViewUiBinder uiBinder = GWT
			.create(SelfViewUiBinder.class);

	interface SelfViewUiBinder extends UiBinder<Widget, SelfView> {
	}

	public SelfView() {
		initWidget(uiBinder.createAndBindUi(this));
		name.setText("Sabbir");
		address.setText("Bhaktapur");
	}

	@UiField
	Label name;
	
	@UiField
	Label address;

	
}
