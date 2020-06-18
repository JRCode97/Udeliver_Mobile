package dev.rivera.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Driver;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
	Driver findByUserNameAndPassWord(String username,String password);
	@Query(value="select SUM(d.tip) from Driver dr,Delivery d where dr.id = d.driver and dr.id=?1")
	double getDriverTotalTip(int id);
	@Query(value="select d.customer from Driver dr,Delivery d where dr.id =d.driver and dr.id=?1")
	List<Customer> getCustomerDriver(int id);
}	
