package com.home.client.activities;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.home.client.services.ServiceProvider;
import com.home.client.view.IMainView;
import com.home.client.view.IMainView.Presenter;
import com.home.server.entities.ContactDetailsEntity;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;

public class MainActivity extends AbstractActivity implements Presenter {

	private final IMainView mainView;
	
	public MainActivity(IMainView mainView){
		this.mainView = mainView;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		mainView.setPresenter(this);
		panel.setWidget(mainView);
		
		getAllContacts();
		//getContactDetails(19);
		//getTest(19);
	}

	@Override
	public List<ContactDetails> getAllContacts() {
		ServiceProvider.getInstance().getContactService().getAllContacts( new AsyncCallback<List<ContactNameId>>() {
			
			@Override
			public void onSuccess(List<ContactNameId> allContactDetails) {
				mainView.setContactsList(allContactDetails);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught.toString());
				
			}
		});
		return null;
	}

	@Override
	public ContactDetails getContactDetails(int id) {
		ServiceProvider.getInstance().getContactService().findContact(id, new AsyncCallback<ContactDetails>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught.toString());
				
			}

			@Override
			public void onSuccess(ContactDetails result) {
				System.out.println(result.toString());
				
			}
		});
		return null;
	}
	
	public void getTest(int id){
		ServiceProvider.getInstance().getContactService().getContact(id, new AsyncCallback<ContactDetails>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught.toString());
				
			}

			@Override
			public void onSuccess(ContactDetails result) {
				System.out.println(result.toString());
				
			}
		});
	}

	@Override
	public void handleContactSelectionChange(int userId) {
		ServiceProvider.getInstance().getContactService().getContact(userId, new AsyncCallback<ContactDetails>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ContactDetails result) {
				mainView.showSelectedContactDetail(result);
				
			}
		});
	}

	@Override
	public void selfViewSelected() {
		this.mainView.showSelfView();
	}

	@Override
	public void contactsViewSelected() {
		this.mainView.showContactsView();		
	}

}
