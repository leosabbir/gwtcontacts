package com.home.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;


@Entity
@Table(name="usercontacts")
public class UserContacts implements IsSerializable {
	
	private int id;
	private String userId;
	private int contactId;
	private boolean shared;
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="userid")
	public String getUserId() {
		return userId;
	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	@Column(name="contactid")
	public int getContactId() {
		return contactId;
	}
	
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	
	@Column(name="shared")
	public boolean isShared() {
		return shared;
	}

}
