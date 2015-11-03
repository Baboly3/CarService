package com.babaktamjidi.carservice.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.babaktamjidi.carservice.entities.Car;
import com.babaktamjidi.carservice.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	Service findByDate(Date date);
	
	List<Car> findByCar(Car car);

	List<Service> findByCarId(Long carId);
	
	@Query("select count(c) from Service c")
	long countTotalServices();

	@Query("SELECT regnr FROM Car c WHERE c.regnr = :regnr")
	String getCar(@Param("regnr") String string);
	
	@Query("SELECT Count(c) from Service c WHERE c.mechanicID = :mechanicid")
	long CountByBrand(@Param("mechanicid") long mechanicid);

	@Query("SELECT Count(c) from Service c WHERE (c.date BETWEEN :date1 AND :date2)") 
	long CountBetweenDates(@Param("date1") Date date1, @Param("date2") Date date2 );
	
	@Query("SELECT Count(c) from Service c WHERE (c.date BETWEEN '' AND :date2)") 
	long CountServiceJanuary();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 1 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForJan();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 2 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForFeb();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 3 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForMar();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 4 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForApr();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 5 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForMaj();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 6 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForJun();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 7 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForJul();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 8 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForAug();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 9 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForSep();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 10 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForOkt();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 11 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForNov();
	
	@Query("SELECT COUNT(1) FROM Service WHERE MONTH(service_Date) = 12 AND YEAR(service_date) = YEAR(NOW())")
	long CountServicesForDec();
}
