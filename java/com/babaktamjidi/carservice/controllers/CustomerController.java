package com.babaktamjidi.carservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.babaktamjidi.carservice.dto.CarDTO;
import com.babaktamjidi.carservice.dto.CustomerDTO;
import com.babaktamjidi.carservice.entities.Customer;
import com.babaktamjidi.carservice.services.CustomerService;
import com.babaktamjidi.carservice.validators.CustomerValidate;

@Controller
public class CustomerController {

	private CustomerService customerService;
	private CustomerValidate customerValidate;

	@Autowired
	public CustomerController(CustomerService customerService, CustomerValidate customerValidate) {
		this.customerService = customerService;
		this.customerValidate = customerValidate;
	}

	@InitBinder("customerDTO")
	public void initCustomerDTOBinder(WebDataBinder binder) {
		binder.setValidator(customerValidate);
	}

	@ModelAttribute("customers")
	public List<Customer> getCustomers() {
		return customerService.getAll();
	}

	@ModelAttribute("customerDTO")
	public CustomerDTO customerDTO() {
		return new CustomerDTO();
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public String newCustomer(Model model) {

		model.addAttribute("customerDTO", new CustomerDTO());

		return "newCustomer";
	}

	@RequestMapping(value = "/newCustomer", method = RequestMethod.POST)
	public String newCustomer(
			@ModelAttribute("customerDTO") @Valid CustomerDTO newCustomer,
			BindingResult result, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()){
			return "newCustomer";}

		customerService.create(newCustomer);

		redirectAttrs.addFlashAttribute("message", "Created the account.");
		return "redirect:/";
	}

	@RequestMapping(value = "/customerManager", method = RequestMethod.GET)
	public String getAll(Model model) {

		model.addAttribute("carDTO", new CarDTO());
		model.addAttribute("title", "Customer Manager");
		
		return "customerManager";
	}

	@RequestMapping(value = "/customerManager", method = RequestMethod.POST)
	public String All(Model model) {

		return "customerManager";
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomer(
			@ModelAttribute("customerDTO") @Valid CustomerDTO customer,
			BindingResult result, RedirectAttributes redirectAttrs) {

			redirectAttrs.addFlashAttribute("message", "Success! Account Updated.");
			customerService.update(customer);

		return "redirect:/customerManager";
	}
	
	
	@RequestMapping(value = "/delCustomer", method = RequestMethod.POST)
	public String delCustomer(
			@ModelAttribute("customerDTO") @Valid CustomerDTO customer,
			BindingResult result, RedirectAttributes redirectAttrs) {

		customerService.delete(customer);
		redirectAttrs.addFlashAttribute("message", "Success! Account deleted.");
		

		return "redirect:/customerManager";

	}
	

}
