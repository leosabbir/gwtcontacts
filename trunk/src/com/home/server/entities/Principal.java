package com.home.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;


@Entity
@Table(name="principal")
public class Principal implements IsSerializable {

	private String emailId;
	private String username;
	private String password;
	private int contactId;
	private String authority;
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Id
	@Column(name="emailid")
	public String getEmailId() {
		return emailId;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	@Column(name="username")
	public String getUserName() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	@Column(name="contactid")
	public int getContactId() {
		return contactId;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Column(name="authority")
	public String getAuthority() {
		return authority;
	}
}
