package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String open(Model mm, Login ll) {
		mm.addAttribute("login", ll);
		return "index";
	}
	
	@RequestMapping(value = "/openSignUp",method = RequestMethod.GET)
	public String openSignUpPage(Model mm, Login ll) {
		mm.addAttribute("login", ll);
		return "signUp";
	}
	
	@RequestMapping(value = "/signIn",method = RequestMethod.POST)
	public String signIn(Model mm, Login ll, HttpSession hs) {
		String result = loginService.signIn(ll);
		
		if(result.equals("Customer login successfully")) {
			hs.setAttribute("emailid", ll.getEmailid());		// stored session object of that person
			hs.setAttribute("typeofuser", ll.getTypeofuser()); // store user type
			return "home";
		}else if(result.equals("Admin login successfully")) {
			hs.setAttribute("emailid", ll.getEmailid());		// stored session object of that person
			hs.setAttribute("typeofuser", ll.getTypeofuser()); // store user type
			//System.out.println("Logging in as admin: "+ll.getTypeofuser()+" : "+ll.toString());
			return "home";
		}else {
			mm.addAttribute("msg", "Email or password maybe incorrect!");
			return "index";
		}
		
		//System.out.println(result);
		//mm.addAttribute("login", ll);
		//return "index";
	}
		
	@RequestMapping(value = "/signUp",method = RequestMethod.POST)
	public String signUp(Model mm, Login ll) {
		String result = loginService.signUp(ll);
		mm.addAttribute("login", ll);
		mm.addAttribute("msg", result);
		System.out.println(result);

		return "index";
	}
	
	@RequestMapping(value = "/changePassword",method = RequestMethod.GET)
	public String changePassword(Model mm, Login ll) {
		System.out.println(ll.getEmailid()+" "+ll.getPassword());
		mm.addAttribute("login", ll);
		return "changePassword";
	}
	
	@RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
	public String updatePassword(Model mm, Login ll) {
		System.out.println("Updating password");
		String result = loginService.updatePassword(ll);
		System.out.println(result);
		mm.addAttribute("login", ll);
		return "changePassword";
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(Model mm, Login ll, HttpSession hs) {
		
		hs.removeAttribute("emailid");
		hs.removeAttribute("typeofuser");
		String result = "You have been logged out";
		mm.addAttribute("msg", result);
		
		return "index";
	}
}
