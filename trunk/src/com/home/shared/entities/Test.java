package com.home.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Test implements IsSerializable {
	
	private String name;
	private String address;
	private String mobile;
	private int userid;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile() {
		return mobile;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUserid() {
		return userid;
	}

}
