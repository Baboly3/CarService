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
import com.babaktamjidi.carservice.dto.ServiceDTO;
import com.babaktamjidi.carservice.entities.Car;
import com.babaktamjidi.carservice.services.CarService;
import com.babaktamjidi.carservice.validators.CarValidate;

@Controller
public class CarController {

	private CarService carService;
	private CarValidate carValidate;

	@Autowired
	public CarController(CarService carService, CarValidate carValidate) {
		this.carService = carService;
		this.carValidate = carValidate;
	}

	@InitBinder("carDTO")
	public void initCarDTOBinder(WebDataBinder binder) {
		binder.setValidator(carValidate);
	}

	@ModelAttribute("cars")
	public List<Car> getCars() {

		return carService.getAll();
	}

	@ModelAttribute("carDTO")
	public CarDTO carDTO() {
		return new CarDTO();
	}
	
	@ModelAttribute("serviceDTO")
	public ServiceDTO serviceDTO() {
		return new ServiceDTO();
	}


	@RequestMapping(value = "/carManager", method = RequestMethod.GET)
	public String carManager(Model model) {

		model.addAttribute("title", "Car Manager");

		return "carManager";
	}

	@RequestMapping(value = "/carManager", method = RequestMethod.POST)
	public String carManager(@ModelAttribute("carDTO") @Valid CarDTO carDTO,
			BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			redirectAttributes.addFlashAttribute("message", "");

			return "redirect:/carManager";
		}

		redirectAttributes.addFlashAttribute("message", "");

		return "redirect:/carManager";
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.GET)
	public String newCustomer(Model model) {

		model.addAttribute("carDTO", new CarDTO());

		return "addCar";
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("carDTO") @Valid CarDTO newCar,
			BindingResult result, RedirectAttributes redirectAttributes) {

		System.out.println("in addCar:" + newCar.getRegnr());

		if (result.hasErrors()) {

			redirectAttributes.addFlashAttribute("errormessage","Failed! Car not added.");
			return "addCar";
		}

		carService.add(newCar);

		redirectAttributes.addFlashAttribute("message", "Success! Car added.");

		return "redirect:/carManager";
	}

	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
	public String deleteCar(@ModelAttribute("carDTO") @Valid CarDTO car,
			BindingResult result, RedirectAttributes redirectAttributes) {

			carService.delete(car);

			redirectAttributes.addFlashAttribute("message","Success! Car deleted.");

	
		return "redirect:/carManager";
	}
	
	@RequestMapping(value = "/updateCar", method = RequestMethod.POST)
	public String updateCar(@ModelAttribute("carDTO") @Valid CarDTO updateCar,
			BindingResult result, RedirectAttributes redirectAttributes) {
			
			carService.update(updateCar);
			redirectAttributes.addFlashAttribute("message", "Success! Car updated.");


		return "redirect:/carManager";
	}
	
}
