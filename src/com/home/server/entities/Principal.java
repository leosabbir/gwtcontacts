package com.home.server.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gwt.user.client.rpc.IsSerializable;


@Entity
@Table(name="principal")
public class Principal implements IsSerializable {

	private String emailId;
	private String username;
	private String password;
	private String authority;
	
	private Set<Contacts> contacts = new HashSet<Contacts>(0);
	
	
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
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Column(name="authority")
	public String getAuthority() {
		return authority;
	}

	@OneToMany(mappedBy="principal", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emailid")
	//@MapKey(name="contacts")
	//@JoinTable(name = "contacts", joinColumns = { @JoinColumn(name = "emailId", nullable = false, updatable = false, referencedColumnName = "emailId") })
	public Set<Contacts> getContacts() {
		return contacts;
	}
	
	public void setContacts(Set<Contacts> contacts){
		this.contacts = contacts;
	}
}
