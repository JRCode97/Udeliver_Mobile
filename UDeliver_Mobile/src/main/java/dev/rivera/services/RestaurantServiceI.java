package dev.rivera.services;

import java.util.List;

import dev.rivera.entities.Restaurant;

public interface RestaurantServiceI {
	Restaurant createRestaurant(Restaurant restaurant);
	
	Restaurant getRestaurantById(int id);
	
	List<Restaurant> getRestaurantDriver(Integer driverId);
	
	Restaurant updateRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(Restaurant restaurant);
	
}
