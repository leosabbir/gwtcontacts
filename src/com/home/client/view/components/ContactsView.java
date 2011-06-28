package com.home.client.view.components;

import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.home.client.view.IMainView.Presenter;
import com.home.shared.entities.ContactDetails;

public class ContactsView extends Composite implements Handler{

	private static ContactsViewUiBinder uiBinder = GWT
			.create(ContactsViewUiBinder.class);

	interface ContactsViewUiBinder extends UiBinder<Widget, ContactsView> {
	}
	
	private Presenter presenter;

	@UiField
	CellTable<ContactDetails> conactsTable;
	
	private SingleSelectionModel<ContactDetails> sinlgeSelectionModel;

	public ContactsView() {
		initWidget(uiBinder.createAndBindUi(this));
		initColumns();
		
		sinlgeSelectionModel = this.createSelectionModel();
		this.sinlgeSelectionModel.addSelectionChangeHandler(this);
		this.conactsTable.setSelectionModel(this.sinlgeSelectionModel);
	}
	
	protected SingleSelectionModel<ContactDetails> createSelectionModel() {
		return new SingleSelectionModel<ContactDetails>();
	}
	
	public void setPresenter(Presenter presenter){
		this.presenter = presenter;
	}
	
	private void initColumns(){
		Column<ContactDetails, String> nameColumn = new Column<ContactDetails, String>(new TextCell()) {

			@Override
			public String getValue(ContactDetails object) {
				return object.getFirstName();
			}
		};
		
		Column<ContactDetails, String> addressColumn = new Column<ContactDetails, String>(new TextCell()) {

			@Override
			public String getValue(ContactDetails object) {
				return object.getFirstName();
			}
		};
		
		Column<ContactDetails, String> mobileColumn = new Column<ContactDetails, String>(new TextCell()) {

			@Override
			public String getValue(ContactDetails object) {
				return object.getMobile();
			}
		};
		
		conactsTable.addColumn(nameColumn, "Name");
		conactsTable.addColumn(addressColumn, "Address");
		conactsTable.addColumn(mobileColumn, "Mobile");
	}
	
	public void setTableData(List<ContactDetails> data){
		this.conactsTable.setRowData(data);
	}

	@Override
	public void onSelectionChange(SelectionChangeEvent event) {
		//this.presenter.handleContactSelectionChange(this.sinlgeSelectionModel.getSelectedObject());
	}
}
