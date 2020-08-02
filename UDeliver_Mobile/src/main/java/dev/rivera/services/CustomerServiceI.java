package dev.rivera.services;

import java.util.List;

import dev.rivera.entities.Customer;

public interface CustomerServiceI {
	Customer createCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(int id);
	
	Customer getCustomerByAddress(String address,String zip);
	
	List<Customer> getCustomerByDriverId(int driverId);
	
	double getCustomerTotalTip(int id);
	
	List<String> getBestTownNames(int id);
	
	List<Double> getBestTownTotals(int id);
	
	List<String> getBestAvgAddress(int id);
	
	List<Double> getBestAvgTip(int id);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(Customer customer);
}
