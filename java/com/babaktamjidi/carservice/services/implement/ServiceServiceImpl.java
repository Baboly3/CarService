package com.babaktamjidi.carservice.services.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babaktamjidi.carservice.dto.ServiceDTO;
import com.babaktamjidi.carservice.entities.Car;
import com.babaktamjidi.carservice.entities.Service;
import com.babaktamjidi.carservice.repositories.CarRepository;
import com.babaktamjidi.carservice.repositories.ServiceRepository;
import com.babaktamjidi.carservice.services.ServiceService;

@Component
public class ServiceServiceImpl implements ServiceService {

	private ServiceRepository serviceRepository;
	private CarRepository carRepository;

	@Autowired
	private ServiceServiceImpl(ServiceRepository serviceRepository,
			CarRepository carRepository) {
		this.serviceRepository = serviceRepository;
		this.carRepository = carRepository;
	}

	@Transactional
	@Override
	public List<Service> getAll() {
		List<Service> services = serviceRepository.findAll();
		return services;
	}

	@Transactional
	@Override
	public void create(ServiceDTO newService) {

		Service service = new Service();
		Car car = carRepository.findByRegnr(newService.getCarRegNr());
		String brand = car.getBrand();
		
		switch (brand) {
		case "Volvo": {
			Long one = Long.valueOf(1);
			service.setService(newService.getDate(), newService.getNote(),car.getId(), one);
			break;
		}
		case "BMW": {
			Long two = Long.valueOf(2);
			service.setService(newService.getDate(), newService.getNote(),car.getId(), two);
			break;
		}
		case "Audi": {
			Long three = Long.valueOf(3);
			service.setService(newService.getDate(), newService.getNote(),car.getId(), three);
			break;
		}		
		case "Mercedes":{			
			Long four = Long.valueOf(4);
			service.setService(newService.getDate(), newService.getNote(),car.getId(), four);			
			break;
		}		
		case "Volkswagen": {
			Long five = Long.valueOf(5);
			service.setService(newService.getDate(), newService.getNote(),car.getId(), five);			
			break;
		}		
		default : {
			Long six = Long.valueOf(6);
			service.setService(newService.getDate(), newService.getNote(),car.getId(), six);			
		}	
	}
		serviceRepository.save(service);
	}

	@Override
	public List<Service> findByCarId(Long id) {
		return serviceRepository.findByCarId(id);
	}

	@Override
	public void delete(Long id) {
		serviceRepository.delete(id);
	}

	@Override
	public Long countTotalServices() {
		return serviceRepository.countTotalServices();
	}

	@Override
	public List<Long> CountByBrand() {
		long volvo = 0;
		long bmw = 0;
		long audi = 0;
		long mercedes = 0;
		long volkswagen = 0;
		List<Long> counts = new ArrayList<Long>();

		volvo = serviceRepository.CountByBrand(1);
		bmw = serviceRepository.CountByBrand(2);
		audi = serviceRepository.CountByBrand(3);
		mercedes = serviceRepository.CountByBrand(4);
		volkswagen = serviceRepository.CountByBrand(5);
		
		counts.add(0, volvo);
		counts.add(1, bmw);
		counts.add(2, audi);
		counts.add(3, mercedes);
		counts.add(4, volkswagen);
		return counts;
	}

	@Override
	public long CountBetweenDates(Date date1, Date date2) {
		return serviceRepository.CountBetweenDates(date1, date2);
	}
	@Transactional
	@Override
	public List<Long> CountServicesYearReport() {
		List<Long> yearReport = new ArrayList<Long>();
		yearReport.add(0, serviceRepository.CountServicesForJan());
		yearReport.add(1, serviceRepository.CountServicesForFeb());
		yearReport.add(2, serviceRepository.CountServicesForMar());
		yearReport.add(3, serviceRepository.CountServicesForApr());
		yearReport.add(4, serviceRepository.CountServicesForMaj());
		yearReport.add(5, serviceRepository.CountServicesForJun());
		yearReport.add(6, serviceRepository.CountServicesForJul());
		yearReport.add(7, serviceRepository.CountServicesForAug());
		yearReport.add(8, serviceRepository.CountServicesForSep());
		yearReport.add(9, serviceRepository.CountServicesForOkt());
		yearReport.add(10,serviceRepository.CountServicesForNov());
		yearReport.add(11,serviceRepository.CountServicesForDec());
		return yearReport;
	}
}
