package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.user;

@Controller
public class HomeController {
	// http://localhost:8080/home
	
	@GetMapping("/home")
	public String home(String name, String addr){
		System.out.println(name);
		System.out.println(addr);
		return "home";
	}
	
	//http://localhost:8080/user
	//exit : http://localhost:8080/user?cmd=loginProc&username=척준경&password=1112
	@GetMapping("/user")
	public String user(user user2, Model model){
		System.out.println(user2.getName());
		System.out.println(user2.getAddr());
		model.addAttribute("user",user2);
		return "user";
	}
	
	@GetMapping("/post")
	public String post(){
		System.out.println("dd");
				
		return "post";
	}
}
