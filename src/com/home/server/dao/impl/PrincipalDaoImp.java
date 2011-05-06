package com.home.server.dao.impl;

import java.util.List;

import com.home.server.dao.PrincpalDao;
import com.home.server.entities.Principal;

public class PrincipalDaoImp extends GenericDaoImpl<Principal> implements PrincpalDao{

	@Override
	public Principal findPrincipalByEmailId(String emailId) {
		List<Principal> principals = getHibernateTemplate().find("from Principal where emailid = ?", new Object[]{emailId});
		return principals.get(0);
	}
}
