package com.home.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;


@Entity
@Table(name="contacts")
public class Contacts implements IsSerializable {
	
	private int contactId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String mobile;
	private String emailId;
	
	private Principal principal;
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}	
	
	@Id
	@GeneratedValue
	@Column(name="contactid")
	public int getContactId() {
		return contactId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="firstname")
	public String getFirstName() {
		return firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name="middlename")
	public String getMiddleName() {
		return middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="lastname")
	public String getLastName() {
		return lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name="emailid")
	public String getEmailId() {
		return emailId;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	@ManyToOne
	@JoinColumn(name = "emailid", nullable = false,  insertable= false, updatable = false)
	public Principal getPrincipal() {
		return principal;
	}

}
