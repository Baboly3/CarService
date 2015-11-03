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

import com.babaktamjidi.carservice.dto.ServiceDTO;
import com.babaktamjidi.carservice.entities.Service;
import com.babaktamjidi.carservice.services.ServiceService;
import com.babaktamjidi.carservice.validators.ServiceValidate;

@Controller
public class ServiceController {

	private ServiceService serviceService;
	private ServiceValidate serviceValidate;

	@Autowired
	public ServiceController(ServiceService serviceService,
			ServiceValidate serviceValidate) {
		this.serviceService = serviceService;
		this.serviceValidate = serviceValidate;

	}

	@InitBinder("serviceDTO")
	public void initServiceDTOBinder(WebDataBinder binder) {
		binder.setValidator(serviceValidate);
	}

	@ModelAttribute("services")
	public List<Service> getServices() {
		return serviceService.getAll();
	}

	@ModelAttribute("carServices")
	public List<Service> getCarService(Long id) {
		return serviceService.findByCarId(id);
	}

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String service(Model model) {
		model.addAttribute("serviceDTO", new ServiceDTO());
		model.addAttribute("title", "Services");
		return "service";
	}
	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public String service(
			@ModelAttribute("serviceDTO") @Valid ServiceDTO service,
			BindingResult result, RedirectAttributes redirectAttrs) {
		if (result.hasErrors())
			return "service";
		redirectAttrs.addFlashAttribute("message", "Services working.");
		return "redirect:/service";
	}
	@RequestMapping(value = "/addService", method = RequestMethod.GET)
	public String addService(Model model) {
		model.addAttribute("serviceDTO", new ServiceDTO());
		return "addService";
	}

	@RequestMapping(value = "/addService", method = RequestMethod.POST)
	public String addService(
			@ModelAttribute("serviceDTO") @Valid ServiceDTO service,
			BindingResult result, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errormessage", "Service not added.");
			return "redirect:/carManager";
		}
		serviceService.create(service);
		System.out.println("car regnr:" + service.getCarRegNr());
		redirectAttrs.addFlashAttribute("message", "Service added.");
		return "redirect:/service";
	}

	@RequestMapping(value = "/carServiceDetails/", method = RequestMethod.GET)
	public String serviceDetails(Model model, RedirectAttributes redirectAttrs) {
		return "redirect:/carServiceDetails";
	}
	@RequestMapping(value = "/carServiceDetails", method = RequestMethod.POST)
	public String serviceDetails(
			@ModelAttribute("serviceDTO") @Valid ServiceDTO service,
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {
		
		if (result.hasErrors()) {
			System.out.println("ERROR");
		}
		List<Service> carServices = serviceService.findByCarId(service.getCarID());
		model.addAttribute("carServices", carServices);
		model.addAttribute("title", "Car Service History");	
		return "carServiceDetails";
	}
	@RequestMapping(value = "/delService", method = RequestMethod.POST)
	public String delService(
			@ModelAttribute("serviceDTO") @Valid ServiceDTO service,
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors()) {
			System.out.println("ERROR");
		}
		serviceService.delete(service.getId());
		redirectAttrs.addFlashAttribute("message", "Service record deleted.");
		return "redirect:/service";
	}
}
