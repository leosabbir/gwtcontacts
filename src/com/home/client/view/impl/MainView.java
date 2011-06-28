package com.home.client.view.impl;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.view.IMainView;
import com.home.client.view.components.AddContact;
import com.home.client.view.components.ContactDetailsView;
import com.home.client.view.components.ContactsList;
import com.home.client.view.components.ContactsView;
import com.home.client.view.components.MainList;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;
import com.home.shared.proxy.ContactsProxy;

public class MainView extends Composite implements IMainView {

	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);
	private Presenter presenter;

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}
	
//	@UiField
//	public FlexTable allContactsHeader;
//
//	@UiField
//	public FlexTable allContactsBody;
	
//	@UiField
//	ContactsView contactsTable;
//	
	
	@UiField
	DeckPanel mainViewDeckContainer;
	
	@UiField
	Label contactsTab;
	
	@UiField
	Label selfTab;
	
	@UiField
	Label addContactTab;
	
	@UiField
	AddContact addContact;

	@UiField
	ContactsList contactsList;
	
	@UiField
	ContactDetailsView contactDetailView;

	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		//this.contactsList.setVisible(false);
		this.mainViewDeckContainer.showWidget(0);
		
		this.contactsTab.addClickHandler( new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				mainViewDeckContainer.showWidget(1);
				
			}
		});
		
		this.selfTab.addClickHandler( new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				mainViewDeckContainer.showWidget(0);
				
			}
		});
		
		this.addContactTab.addClickHandler( new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				mainViewDeckContainer.showWidget(2);
				
			}
		});

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		//this.contactsTable.setPresenter(presenter);
		this.contactsList.setPresenter(presenter);
		this.addContact.setPresenter(presenter);
		
	}

	@Override
	public void setContactsList(List<ContactNameId> allContactDetails) {
		//this.contactsTable.setTableData(allContactDetails);
		this.contactsList.setTableData(allContactDetails);
	}
	
	@Override
	public void showSelectedContactDetail(ContactsProxy contactDetails){
		this.contactDetailView.setData(contactDetails);
	}

	@Override
	public void showSelfView() {
		
	}

	@Override
	public void showContactsView() {
		
	}

}
