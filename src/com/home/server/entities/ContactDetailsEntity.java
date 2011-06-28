package com.home.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="contactdetails")
public class ContactDetailsEntity implements IsSerializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String emailId;
	private String name;
	private String mobile;
	private String address;
	
	public ContactDetailsEntity(){
	}

	
	@Id
	@GeneratedValue
	@Column(name="userid")
	public Integer getUserId(){
		return this.userId;
	}
	
	public void setUserId(Integer value){
		this.userId = value;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name="emailid")
	public String getEmailId() {
		return emailId;
	}
}
