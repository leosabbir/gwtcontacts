package com.home.server.dao;

import com.home.server.entities.Principal;

public interface PrincpalDao extends GenericDao<Principal>{
	public Principal findPrincipalByEmailId(String emailId);
}
