package com.home.server.web.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView loginView = new ModelAndView("login");
		loginView.addObject("msg", "Login is required!!");
		return loginView;
	}
}
