package com.home.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ContactNameId implements IsSerializable {

	private String name;
	private int userid;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUserid() {
		return userid;
	}
}
