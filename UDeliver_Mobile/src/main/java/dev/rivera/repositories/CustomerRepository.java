package dev.rivera.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Driver;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	Customer findByAddressAndZip(String address,String zip);

	@Query(value="select sum(d.tip) from Customer c,Delivery d where c.id = d.customer and c.id=?1")
	Double getCustomerTipTotal(int id);
}
