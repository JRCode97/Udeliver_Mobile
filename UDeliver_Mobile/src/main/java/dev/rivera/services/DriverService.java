package dev.rivera.services;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Driver;
import dev.rivera.repositories.DriverRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class DriverService implements DriverServiceI {
	@Autowired
	DriverRepository dr;
	@Override
	public Driver createDriver(Driver driver) {
		return dr.save(driver);
	}

	@Override
	public Driver loginDriver(String username, String password) {
		return dr.findByUserNameAndPassWord(username, password);
	}

	@Override
	public Driver getDriverById(int id) {
		return dr.findById(id).get();
	}

	@Override
	public Double getDriverTotalEarnings(int id) {
		return dr.getDriverTotalTip(id);
	}
	
	@Override
	public Driver updateDriver(Driver driver) {
		return dr.save(driver);
	}

	@Override
	public void deleteDriver(Driver driver) {
		dr.delete(driver);
	}

	@Override
	public List<Customer> getVisitedCustomers(int id) {
		return dr.getCustomerDriver(id);
	}

}
