package org.java.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YearController {
	
	@GetMapping("/")
	@ResponseBody
	public String sayHello() {
		return "hello";
	}
}
