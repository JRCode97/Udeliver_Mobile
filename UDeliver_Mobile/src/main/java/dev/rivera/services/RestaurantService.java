package dev.rivera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.rivera.entities.Restaurant;
import dev.rivera.repositories.DriverRepository;
import dev.rivera.repositories.RestaurantRepository;
@Component
@Service
public class RestaurantService implements RestaurantServiceI {
	@Autowired
	RestaurantRepository rr;
	@Autowired
	DriverRepository dr;
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return rr.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		return rr.findById(id).get();
	}

	@Override
	public List<Restaurant> getRestaurantDriver(Integer driverId) {
		
		return rr.findByDriver(dr.findById(driverId).get());
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return rr.save(restaurant);
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		rr.delete(restaurant);
	}

}
