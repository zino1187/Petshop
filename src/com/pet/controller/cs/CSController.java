package com.pet.controller.cs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CSController {
	
	@RequestMapping(value="/cs/list", method=RequestMethod.GET)
	public String selectAll(Model model) {
		List boardList = new ArrayList();
		model.addAttribute("boardList", boardList);
		return "cs/list";
	}
}








