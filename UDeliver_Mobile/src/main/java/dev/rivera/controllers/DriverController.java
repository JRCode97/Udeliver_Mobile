package dev.rivera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rivera.entities.Driver;
import dev.rivera.services.DriverService;

@Component
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DriverController {
	@Autowired
	DriverService ds;
	@PostMapping(value="/drivers")
	public Driver createDriver(@RequestBody Driver driver) {
		return ds.createDriver(driver);
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value= {"/drivers/{id}","drivers/{username}/{password}","drivers/tip/{driverid}","drivers/customer/{custDriverId}"})
	public <T>T getDriver(@PathVariable(required=false)Integer id,@PathVariable(required=false)String username,@PathVariable(required=false)String password,@PathVariable(required=false) Integer driverId,@PathVariable(required=false) Integer custDriverId){
		if(id!=null) {
			return (T) ds.getDriverById(id);
		}else if(username!=null && password!=null) {
			return (T) ds.loginDriver(username, password);
		}else if(driverId!=null) {
			return (T) ds.getDriverTotalEarnings(driverId);
		}else if(custDriverId!=null) {
			return (T) ds.getVisitedCustomers(custDriverId);
		}
		else 
			return null;
	}
	@PutMapping(value="/drivers")
	public Driver updateDriver(@RequestBody Driver driver) {
		return ds.updateDriver(driver);
	}
	@DeleteMapping(value="/drivers")
	public void deleteDriver(@RequestBody Driver driver) {
		 ds.deleteDriver(driver);
	}
}
