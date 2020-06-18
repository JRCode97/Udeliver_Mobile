package dev.rivera.services;

import java.util.List;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Driver;

public interface DriverServiceI {
	Driver createDriver(Driver driver);
	
	Driver loginDriver(String username,String password);
	
	Driver getDriverById(int id);
	
	Double getDriverTotalEarnings(int id);
	
	List<Customer> getVisitedCustomers(int id);
	
	Driver updateDriver(Driver driver);
	
	void deleteDriver(Driver driver);
}
