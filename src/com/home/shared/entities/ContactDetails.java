package com.home.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ContactDetails implements IsSerializable {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String mobile;
	private String emailId;
	private int userid;
	
	public ContactDetails(){
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getFirstName() {
		return firstName;
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
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

}
