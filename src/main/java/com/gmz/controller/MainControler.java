package com.gmz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControler {
	
	@RequestMapping(value="/home")
	public String afficherIndex() {
		return "index";
	}
	
}
