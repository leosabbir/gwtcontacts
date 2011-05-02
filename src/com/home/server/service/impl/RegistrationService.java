package com.home.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.AuthenticationException;

import com.home.server.dao.IContactsDao;
import com.home.server.entities.Authorities;
import com.home.server.entities.Principal;
import com.home.server.service.IRegistrationService;
import com.home.server.web.model.RegistrationModel;

public class RegistrationService implements IRegistrationService {

	private final IContactsDao contactsDao;
	private final PasswordEncoder passwordEncoder;
	
	public RegistrationService(IContactsDao contactsDao, PasswordEncoder passwordEncoder){
		this.contactsDao = contactsDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void registerUser(RegistrationModel registrationModel) throws AuthenticationException {
		Principal user = (Principal) contactsDao.findPrincipal(registrationModel.getUserName());
		if (user != null) {
			throw new AuthenticationException("Duplicate.registrationModel.userName") {};
		}

		if (registrationModel.getEmail() != null && registrationModel.getEmail() != "") {
			user = contactsDao.findPrincipalByEmailId(registrationModel.getEmail());
			if (user != null) {
				throw new AuthenticationException("Duplicate.registrationModel.email"){};
			}
		}

		user = new Principal();
		user.setUserName(registrationModel.getUserName());
		user.setPassword(passwordEncoder.encodePassword(registrationModel.getPassword(), null));
		user.setEmailId(registrationModel.getEmail());
		user.setAuthority(Authorities.Authenticated);
		contactsDao.savePrincipal(user);
		
	}

}
