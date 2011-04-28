package com.home.client.resources;

import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.user.cellview.client.CellTable.Resources;
import com.google.gwt.user.cellview.client.CellTable.Style;

public interface CellTableResources extends Resources {
	@Source({ "celltable.css" })
	Style cellTableStyle();
}
