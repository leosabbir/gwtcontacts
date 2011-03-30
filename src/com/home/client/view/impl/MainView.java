package com.home.client.view.impl;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.home.client.view.IMainView;
import com.home.shared.entities.ContactDetails;

public class MainView extends Composite implements IMainView {

	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);
	private Presenter presenter;

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}
	
	@UiField
	public FlexTable allContactsHeader;

	@UiField
	public FlexTable allContactsBody;


	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		initAllContactsTable();
	}

	@Override
	public void initAllContactsTable() {
		allContactsBody.setCellSpacing(0);
		//allContactsBodyHeader.setCellPadding(3);

		allContactsBody.setWidth("100%");
		allContactsHeader.setWidth("100%");

		allContactsHeader.setText(0, 0, "Name");
		allContactsHeader.getCellFormatter().setWidth(0, 0, "100px");
		allContactsBody.getCellFormatter().setWidth(0, 0, "101px");

		allContactsHeader.setText(0, 1, "Address");
		allContactsHeader.getCellFormatter().setWidth(0, 1, "100px");
		allContactsBody.getCellFormatter().setWidth(0, 1, "100px");

		allContactsHeader.setText(0, 2, "Mobile");
		//		allContactsHeader.getCellFormatter().setWidth(0, 2, "40%");
		//		allContactsBody.getCellFormatter().setWidth(0, 2, "40%");

		
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public void setContactsTable(List<ContactDetails> allContactDetails) {
		int row = 0;
		for (ContactDetails contactDetail : allContactDetails) {
				allContactsBody.setText(row, 0, contactDetail.getName());
				allContactsBody.setText(row, 1, contactDetail.getAddress());
				allContactsBody.setText(row, 2, contactDetail.getMobile());

				row++;
		}
	}

}
