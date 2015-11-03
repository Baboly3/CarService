package com.babaktamjidi.carservice.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.babaktamjidi.carservice.dto.ServiceDTO;
import com.babaktamjidi.carservice.entities.Service;

public interface ServiceService {

	List<Service> getAll();

	void create(ServiceDTO service);
	
	List<Service> findByCarId(Long id);
	
	void delete(Long id);

	Long countTotalServices();
	
	List<Long> CountByBrand();
	
	long CountBetweenDates(@Param("servicedate1") Date date1, @Param("servicedate2") Date date2 );
	
	List<Long> CountServicesYearReport();
	
//	long CountServiceForMales();
}
