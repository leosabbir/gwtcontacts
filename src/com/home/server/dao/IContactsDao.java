package com.home.server.dao;

import java.util.List;

import com.home.server.entities.Contacts;
import com.home.server.entities.Principal;
import com.home.server.entities.UserContacts;

public interface IContactsDao {
    public List<Contacts> getAllContacts();
	
    public boolean saveContact(Contacts contact);
    public boolean savePrincipal(Principal principal);
	public boolean saveUserContact(UserContacts userContact);
	
	public boolean updateContact(Contacts contact);
	public boolean updatePrincipal(Principal principal);
	public boolean updateUserContact(UserContacts userContact);
	
	public boolean deleteContact(Contacts contact);
	public boolean deletePrincipal(Principal principal);
	public boolean deleteUserContact(UserContacts userContact);
	
	public UserContacts findUserContact(int usesrContactId);
	public Principal findPrincipal(String usesrname);
	public Principal findPrincipalByEmailId(String emailId);
	public Contacts findContact(int contactId);
}
