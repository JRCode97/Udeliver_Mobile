package dev.rivera.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rivera.entities.Driver;
import dev.rivera.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
	List<Restaurant> findByDriver(Driver driver);
	
}
