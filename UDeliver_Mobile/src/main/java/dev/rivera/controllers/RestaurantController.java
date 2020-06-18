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

import dev.rivera.entities.Restaurant;
import dev.rivera.services.RestaurantService;

@Component
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestaurantController {
	@Autowired 
	RestaurantService rs;
	@PostMapping(value="/restaurants")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return rs.createRestaurant(restaurant);
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value= {"/restaurants/{id}","restaurants/driver/{driverId}"})
	public <T>T getRestaurant(@PathVariable(required=false) Integer id,@PathVariable(required=false) Integer driverId){
		if(id != null) {
			return (T) rs.getRestaurantById(id);
		}
		else if(driverId!=null) {
			return (T) rs.getRestaurantDriver(driverId);
		}
		return null;
	}
	@PutMapping(value="/restaurants")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		return rs.updateRestaurant(restaurant);
	}
	@DeleteMapping(value="/restaurants")
	public void deleteRestaurant(@RequestBody Restaurant restaurant){
		rs.deleteRestaurant(restaurant);
	}
}
