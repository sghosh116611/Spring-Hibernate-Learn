package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-world";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		String name = request.getParameter("name");

		model.addAttribute("name", "Yo! " + name.toUpperCase());

		return "processForm";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("name") String name, Model model) {

		model.addAttribute("name", "Hello my friend from v3: " + name.toUpperCase());

		return "processForm";
	}
}
