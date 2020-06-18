package dev.rivera.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Delivery;
import dev.rivera.entities.Driver;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer>{
	List<Delivery> findByCustomer(Customer customer);
	List<Delivery> findByDriver(Driver driver);
}
