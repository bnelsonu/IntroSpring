package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/") 
	public String welcome(Model model){
		/*from de model to the controller*/
		model.addAttribute("greeting","Welcome to WebStore!");
		model.addAttribute("tagline","The one and only amazing web store");
		
		return "welcome";
	}
	
}
