package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		// adding student object to the model
		model.addAttribute("student", new Student());

		// adding country object to the model
		model.addAttribute("theCountryOptions", countryOptions);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {

		// log the input data
		System.out.println(
				"The Student:" + student.getFirstName() + " " + student.getLastName() + " " + student.getCountry());
		return "student-confirmation";
	}
}
