package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer-tracker")
public class CustomerController {

	// need to inject the DI
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(@RequestParam(required = false) String sort, Model theModel) {

		// get the customers from the service
		List<Customer> customers = null;

		// check for sort field
		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			customers = customerService.getCustomers(theSortField);
		} else {
			customers = customerService.getCustomers(SortUtils.LAST_NAME);
		}

		// add the customers to the model
		theModel.addAttribute("customers", customers);

		return "list-customer";

	}

	@GetMapping("/showFormForAdd")
	public String showForForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";

	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using the service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer-tracker/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the Customer from the service
		Customer theCustomer = customerService.getCustomer(theId);

		// set Custoer as model attribute to prepopulate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to the form
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {

		// call customer service to delete
		customerService.deleteCustomer(theId);

		// redirect to customer list
		return "redirect:/customer-tracker/list";

	}

	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search customers from the service
		List<Customer> customers = customerService.searchCustomers(theSearchName);

		// add the customers to the model
		theModel.addAttribute("customers", customers);
		return "list-customer";
	}

}
