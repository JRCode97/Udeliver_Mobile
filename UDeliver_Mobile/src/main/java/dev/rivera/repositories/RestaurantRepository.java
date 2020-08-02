package dev.rivera.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.rivera.entities.Driver;
import dev.rivera.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
	List<Restaurant> findByDriver(Driver driver);
	
	@Query(value="select r.Name from Restaurant r,Delivery d,Driver dr where dr.id = ?1 and d.driver = dr.id and r.id = d.restaurant group by r.Name ")
	List<String> getTopRestaurants(int id);
}
