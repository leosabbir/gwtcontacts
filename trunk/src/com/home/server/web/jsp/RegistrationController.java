package com.home.server.web.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.server.service.IRegistrationService;
import com.home.server.web.model.RegistrationModel;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;

@Controller
public class RegistrationController {

	private final CaptchaService captchaService;
	private final IRegistrationService registrationService;

	public RegistrationController(IRegistrationService registrationService, CaptchaService captchaService) {
		this.captchaService = captchaService;
		this.registrationService = registrationService;
	}

	@ModelAttribute("registrationModel")
	public RegistrationModel getModel() {
		return new RegistrationModel();

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(ModelMap modelMap) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("registrationModel") @Valid RegistrationModel registrationModel, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "register";
		}

		if (registrationModel.getUserName().trim().length() == 0) {
			result.rejectValue("userName", "NotEmpty.registrationModel.userName");
			return "register";
		}

		String userNamePattern = "^[a-zA-Z0-9_-]{1,}$";
		if (!(registrationModel.getUserName().matches(userNamePattern))) {
			result.rejectValue("userName", "CharacterRestrict.registrationModel.userName");
			return "register";
		}

		try {
			if (!captchaService.validateResponseForID(request.getSession().getId(), registrationModel.getKeyCode())) {
				result.rejectValue("keyCode", "registration.captcha.invalid");
				return "register";
			}
		} catch (CaptchaServiceException ex) {
			result.rejectValue("keyCode", "registration.captcha.invalid");
			return "register";
		}

		if (registrationModel.getPassword().trim().equals("")) {
			result.rejectValue("password", "NotEmpty.registrationModel.password");
			return "register";
		}
		
		if (!registrationModel.getPassword().equals(registrationModel.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "NoMatch.registrationModel.confirmPassword");
			return "register";
		}

		try {
			registrationService.registerUser(registrationModel);
		} catch (AuthenticationException e) {
			result.reject(e.getMessage());
		}

		if (result.hasErrors()) {
			return "register";
		}

		//return "redirect:" + Urls.LOGIN + "?msg=registration.user.success";
		return "redirect:/login?msg=registration.user.success";
	}
}
