package com.home.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface ContactsResources extends ClientBundle {

	public static final ContactsResources INSTANCE = GWT.create(ContactsResources.class);

	@NotStrict
	@Source("contacts.css")
	ContactsCssResource contactsCss();
}
