package com.home.shared.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.home.server.entities.ContactDetailsEntity;
import com.home.shared.entities.ContactDetails;


/**
 * The async counterpart of <code>ContactService</code>.
 */
public interface IContactServiceAsync {

	void addContact(ContactDetails contact, AsyncCallback<Boolean> callBack);
	void update(ContactDetails contact, AsyncCallback<Boolean> callBack);
	void deleteContact(int contactId, AsyncCallback<Boolean> callBack);
	void findContact(int contactid, AsyncCallback<ContactDetails> callBack);
	void getAllContacts(AsyncCallback<List<ContactDetails>> callBack);
	void getContact(int contactId, AsyncCallback<ContactDetails> callback);
}
