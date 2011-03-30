package com.home.shared.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gwt.user.client.rpc.IsSerializable;

@Entity
@Table(name="contactdetails")
public class ContactDetails implements IsSerializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String name;
	private String mobile;
	private String address;
	
	public ContactDetails(){
	}

	
	@Id
	@GeneratedValue
	@Column(name="userid")
	public Integer getId(){
		return this.userId;
	}
	
	public void setId(Integer value){
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
}
