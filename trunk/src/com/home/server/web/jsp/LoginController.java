package com.home.server.web.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login( ModelMap modelMap, @RequestParam(value = "spring-security-redirect", required = false) String redirect) {
		ModelAndView loginView = new ModelAndView("login");
		
		/*if( StringUtils.hasText(redirect) ){
			modelMap.put("action", "/j_spring_security_check?spring-security-redirect=testt");
		}else{
			modelMap.put("action", "/j_spring_security_check");
		}*/
		modelMap.put("action", "/j_spring_security_check");
		loginView.addObject("msg", "Login is required!!");
		return loginView;
	}
}
