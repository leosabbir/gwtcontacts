package com.home.client.view.components;

import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.RowStyles;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.home.client.resources.CellTableResources;
import com.home.client.view.IMainView.Presenter;
import com.home.shared.entities.ContactDetails;
import com.home.shared.entities.ContactNameId;

public class ContactsList extends Composite implements Handler {

	private static ContactsListUiBinder uiBinder = GWT
			.create(ContactsListUiBinder.class);

	interface ContactsListUiBinder extends UiBinder<Widget, ContactsList> {
	}
	
	private Presenter presenter;

	@UiField(provided = true)
	CellTable<ContactNameId> contactsList;
	private SingleSelectionModel<ContactNameId> sinlgeSelectionModel;
	
	public ContactsList() {
		CellTableResources resource = (CellTableResources)GWT.create(CellTableResources.class);
		contactsList = new CellTable<ContactNameId>(100, resource);
		initWidget(uiBinder.createAndBindUi(this));
		
		initColumns();
		
		this.sinlgeSelectionModel = this.createSelectionModel();
		this.sinlgeSelectionModel.addSelectionChangeHandler(this);
		this.contactsList.setSelectionModel(this.sinlgeSelectionModel);
		
	}
	
	protected SingleSelectionModel<ContactNameId> createSelectionModel() {
		return new SingleSelectionModel<ContactNameId>();
	}
	
	public void setPresenter(Presenter presenter){
		this.presenter = presenter;
	}
	
	public void setTableData(List<ContactNameId> data){
		this.contactsList.setRowData(data);
	}
	
	
	private void initColumns(){
		Column<ContactNameId, String> nameColumn = new Column<ContactNameId, String>(new TextCell()) {

			@Override
			public String getValue(ContactNameId object) {
				return object.getName();
			}
		};
		
		contactsList.addColumn(nameColumn);
		
//		contactsList.setRowStyles(new RowStyles<ContactNameId>() {
//				@Override
//				public String getStyleNames(ContactNameId row, int rowIndex) {
//					if (contactsList.getSelectionModel().isSelected(row)) {
//						return "listrow-selected-active";
//					} else if (rowIndex % 2 == 0) {
//						return "cellTableEvenRow";
//					} else {
//						return "cellTableOddRow";//"listrow";
//					}
//				}
//			});
	}


	@Override
	public void onSelectionChange(SelectionChangeEvent event) {
		presenter.handleContactSelectionChange(this.sinlgeSelectionModel.getSelectedObject().getUserid());
		
	}

}
