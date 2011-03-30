package com.home.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.home.shared.entities.ContactDetails;

public interface IMainView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	
	void initAllContactsTable();
	
	void setContactsTable(List<ContactDetails> allContactDetails);
	
	public interface Presenter{
		List<ContactDetails> getAllContacts();
		ContactDetails getContactDetails(int id);
		
	}

}
