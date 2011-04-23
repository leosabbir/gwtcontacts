package com.home.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;

public interface IMainView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	
	void setContactsList(List<ContactNameId> allContactDetails);
	
	void showSelectedContactDetail(ContactDetails contactDetails);
	
	void showSelfView();
	
	void showContactsView();
	
	public interface Presenter{
		List<ContactDetails> getAllContacts();
		ContactDetails getContactDetails(int id);
		void handleContactSelectionChange(int userId);
		void selfViewSelected();
		void contactsViewSelected();
		
	}
}
