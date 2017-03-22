package com.niit.shopgirl.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage(){
		System.out.pritnln("Executing the code");
		return "home";
	}
	
	@RequestMapping("/login")
	public String showLoginPage(){
		return "login";
	}
	
	@RequestMapping("/register")
	public String showRegistrationPage(){
		return "registration";
	}
	
	
}
