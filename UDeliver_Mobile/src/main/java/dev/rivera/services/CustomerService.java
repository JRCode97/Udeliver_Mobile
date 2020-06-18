package dev.rivera.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.rivera.entities.Customer;
import dev.rivera.repositories.CustomerRepository;
@Component
@Service
public class CustomerService implements CustomerServiceI {
	@Autowired
	CustomerRepository cr;
	
	@Override
	public Customer createCustomer(Customer customer) {
		return cr.save(customer);
	}
	
	@Override
	public Customer getCustomerById(int id) {
		return cr.findById(id).get();
	}

	@Override
	public Customer getCustomerByAddress(String address, String zip) {
		return cr.findByAddressAndZip(address, zip);
	}

	@Override
	public double getCustomerTotalTip(int id) {
		return cr.getCustomerTipTotal(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return cr.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		cr.delete(customer);
	}

}
