package com.babaktamjidi.carservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.babaktamjidi.carservice.dto.ServiceDTO;
import com.babaktamjidi.carservice.services.CarService;
import com.babaktamjidi.carservice.services.CustomerService;
import com.babaktamjidi.carservice.services.ServiceService;

@Controller
public class StatisticController {
		
	private CarService carService;
	private ServiceService serviceService;
	private CustomerService customerService;
	
	@Autowired
	public StatisticController(CarService carService, ServiceService serviceService,
			CustomerService customerService) {
		this.carService = carService;
		this.serviceService = serviceService;
		this.customerService = customerService;
	}	
	@RequestMapping(value = "/statistic/totalStat", method = RequestMethod.GET)
	public String totalStat(Model model) {

		           Long totalServices = serviceService.countTotalServices();
		           System.out.println("count:" + totalServices);
		           
		           Long totalCustomers = customerService.countTotalCustomers();
		           Long totalCars = carService.countTotalCars();
		           
		           model.addAttribute("totalServices", totalServices); 
		           model.addAttribute("totalCustomers", totalCustomers);
		           model.addAttribute("totalCars", totalCars);

		           model.addAttribute("title", "Statistic Total Amounts");
		           
		return "/statistic/statistics";
	}	
	@RequestMapping(value = "/statistic/brandStat", method = RequestMethod.GET)
	public String totalbyBrand(Model model) {
		
		  List<Long> brands = serviceService.CountByBrand();
		  long volvo = brands.get(0);
		  long bmw = brands.get(1);
		  long audi = brands.get(2);
		  long mercedes = brands.get(3);
		  long volkswagen = brands.get(4);
		  
		 model.addAttribute("volvo", volvo);
		 model.addAttribute("bmw", bmw);
		 model.addAttribute("audi", audi);
		 model.addAttribute("mercedes", mercedes);
		 model.addAttribute("volkswagen", volkswagen);		 
		 model.addAttribute("title", "Services by brand");	 
		return "/statistic/brandStat";
	}
	@RequestMapping(value = "/statistic/brandStat", method = RequestMethod.POST)
	public String totalbyBrand(RedirectAttributes redirectAttributes) {
		return "redirect:/statistic/brandStat";
	}
	@RequestMapping(value = "/statistic/dateStat", method = RequestMethod.GET)
	public String totalByDate(Model model) {
		
		model.addAttribute("title", "Services Between Dates"); 		
		model.addAttribute("serviceDTO", new ServiceDTO());		 
		return "/statistic/dateStat";
	}
	@RequestMapping(value = "/statistic/dateStat", method = RequestMethod.POST)
	public String totalByDate(
			@ModelAttribute("serviceDTO") @Valid ServiceDTO dates,
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {
		
		model.addAttribute("title", "Services Between Dates"); 
	
		 long count = serviceService.CountBetweenDates(dates.getDate(), dates.getDate1()); 
		 model.addAttribute("dateCount", count);	
		 
		return "/statistic/dateStat";
	}
	
	@RequestMapping(value = "/statistic/genderStat", method = RequestMethod.GET)
	public String genderStat(Model model) {
		
		List<Long> gender = customerService.countServiceByGender();
		
		model.addAttribute("female", gender.get(0));
		model.addAttribute("male", gender.get(1));	
		model.addAttribute("title", "Services by gender"); 		 
		return "/statistic/genderStat";
	}

	@RequestMapping(value = "/statistic/yearStat", method = RequestMethod.GET)
	public String yearStat(Model model) {
		
		List<Long> yearReport = serviceService.CountServicesYearReport();		
		model.addAttribute("jan", yearReport.get(0));
		model.addAttribute("feb", yearReport.get(1));
		model.addAttribute("mar", yearReport.get(2));
		model.addAttribute("apr", yearReport.get(3));
		model.addAttribute("maj", yearReport.get(4));
		model.addAttribute("jun", yearReport.get(5));
		model.addAttribute("jul", yearReport.get(6));
		model.addAttribute("aug", yearReport.get(7));
		model.addAttribute("sep", yearReport.get(8));
		model.addAttribute("okt", yearReport.get(9));
		model.addAttribute("nov", yearReport.get(10));
		model.addAttribute("dec", yearReport.get(11));
		model.addAttribute("title", "Service Year Report"); 			 
		return "/statistic/yearStat";
	}	
}
