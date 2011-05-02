package com.home.server.service;

import org.springframework.security.core.AuthenticationException;
import com.home.server.web.model.RegistrationModel;

public interface IRegistrationService {

	void registerUser(RegistrationModel registrationModel) throws AuthenticationException;
}
