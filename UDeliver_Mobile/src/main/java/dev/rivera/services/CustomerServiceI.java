package dev.rivera.services;

import dev.rivera.entities.Customer;

public interface CustomerServiceI {
	Customer createCustomer(Customer customer);
	
	Customer getCustomerById(int id);
	
	Customer getCustomerByAddress(String address,String zip);
	
	double getCustomerTotalTip(int id);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(Customer customer);
}
