package com.adl.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String helloWorld(){
		return "index0";
	}
	
	@GetMapping("/dora")
	public String helloDora(){
		return "index";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello 2";
	}
}
