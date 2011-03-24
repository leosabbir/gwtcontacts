package com.home.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value = "/test")
	public ModelAndView test(){
		return new ModelAndView("test");
	}
	
	@RequestMapping(value = "/")
	public ModelAndView main(){
		return new ModelAndView("main");
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(){
		ModelAndView loginView = new ModelAndView("login");
		loginView.addObject("msg", "Login is required!!");
		return loginView;
	}
	
	

}
