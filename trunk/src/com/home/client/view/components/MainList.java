package com.home.client.view.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.view.IMainView.Presenter;

public class MainList extends Composite {

	private static MainListUiBinder uiBinder = GWT
			.create(MainListUiBinder.class);

	interface MainListUiBinder extends UiBinder<Widget, MainList> {
	}

	private Presenter presenter;
	
	@UiField
	Anchor self;
	
	@UiField
	Anchor contacts;
	
	public MainList() {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.self.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				presenter.selfViewSelected();
				
			}
		});
		
		this.contacts.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				presenter.contactsViewSelected();
			}
		});
	}
	

	
	public void InvertSelection(){
		
	}

	public void setPresenter(Presenter presenter){
		this.presenter = presenter;
	}


}
