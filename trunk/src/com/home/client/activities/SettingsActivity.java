package com.home.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.home.client.view.ClientFactory;
import com.home.client.view.SettingsView;
import com.home.client.view.SettingsView.Presenter;

public class SettingsActivity extends AbstractActivity implements Presenter {
	
	SettingsView settingsView;
	ClientFactory clientFactory;
	
	public SettingsActivity( SettingsView settingsView){
		this.settingsView = settingsView;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(this.settingsView);
		
	}

}
