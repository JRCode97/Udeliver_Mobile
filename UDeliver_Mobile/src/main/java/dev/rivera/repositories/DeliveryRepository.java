package dev.rivera.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Delivery;
import dev.rivera.entities.Driver;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer>{
	List<Delivery> findByCustomer(Customer customer);
	List<Delivery> findByDriver(Driver driver);
	
	@Query(value="select d from Delivery d,Driver dr where d.orderTime > ?1 and d.orderTime < ?2 and dr.id = d.driver and dr.id = ?3 ")
	List<Delivery> getDeliveries(long startTime, long endTime,int id);
}
;