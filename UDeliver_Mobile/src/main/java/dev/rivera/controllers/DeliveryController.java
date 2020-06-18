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

import dev.rivera.entities.Delivery;
import dev.rivera.services.DeliveryService;

@Component
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeliveryController {
	@Autowired
	DeliveryService ds;
	
	@PostMapping(value="/deliveries")
	public Delivery createDelivery(@RequestBody Delivery delivery) {
		return ds.createDelivery(delivery);
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value= {"/deliveries/{id}","/deliveries/driver/{driverId}","deliveries/customer/{customerId}"})
	public <T>T getDelivery(@PathVariable(required=false)Integer id,@PathVariable(required=false)Integer driverId,@PathVariable(required=false)Integer customerId){
		if(id!=null) {
			return (T) ds.getDeliveryById(id);
		}else if(driverId!=null) {
			return (T) ds.getDriverDeliveries(driverId);
		}else if(customerId!=null) {
			return (T) ds.getCustomerDeliveries(customerId);
		}else
		return null;
	}
	@PutMapping(value="/deliveries")
	public Delivery updateDelivery(@RequestBody Delivery delivery) {
		return ds.updateDelivery(delivery);
	}
	@DeleteMapping(value="/deliveries")
	public void deleteDelivery(@RequestBody Delivery delivery) {
		 ds.deleteDelivery(delivery);
	}
}
