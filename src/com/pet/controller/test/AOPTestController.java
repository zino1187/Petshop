package com.pet.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AOPTestController {
	
	@RequestMapping(value="/aop/test", method=RequestMethod.GET)
	public String execute(HttpServletRequest request) {
		return "test/result";
	}
	
}


