package com.home.client.view.impl;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.view.IMainView;
import com.home.client.view.components.ContactDetailsView;
import com.home.client.view.components.ContactsList;
import com.home.client.view.components.ContactsView;
import com.home.client.view.components.MainList;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;

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
	MainList mainList;
	
	@UiField
	ContactsList contactsList;
	
	@UiField
	ContactDetailsView contactDetailView;

	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		this.contactsList.setVisible(false);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		//this.contactsTable.setPresenter(presenter);
		this.mainList.setPresenter(presenter);
		this.contactsList.setPresenter(presenter);
		
	}

	@Override
	public void setContactsList(List<ContactNameId> allContactDetails) {
		//this.contactsTable.setTableData(allContactDetails);
		this.contactsList.setTableData(allContactDetails);
	}
	
	@Override
	public void showSelectedContactDetail(ContactDetails contactDetails){
		this.contactDetailView.setData(contactDetails);
	}

	@Override
	public void showSelfView() {
		this.mainList.InvertSelection();
		this.contactsList.setVisible(false);
		
	}

	@Override
	public void showContactsView() {
		this.mainList.InvertSelection();
		this.contactsList.setVisible(true);
		
	}

}
