package dev.rivera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.rivera.entities.Customer;
import dev.rivera.services.CustomerService;

@Component
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	@Autowired
	CustomerService cs;
	@PostMapping(value="/customers")
	public Customer signUp(@RequestBody Customer customer){
		return cs.createCustomer(customer);
	}
	@SuppressWarnings("unchecked")
	@GetMapping(value= {"/customers","/customers/{id}","/customers{address}/{zip}"})
	public <T>T getCustomer(@PathVariable(required=false)Integer id,@RequestParam(required=false)String address,@RequestParam(required=false)String zip){
		if(id != null) {
			return (T) cs.getCustomerById(id);
		}
		else if (address != null && zip != null) {
			return (T) cs.getCustomerByAddress(address, zip);
		}
		return null;
	}
	@PutMapping(value="/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return cs.updateCustomer(customer);
	}
	@DeleteMapping(value="/customers")
	public void deleteCustomer(@RequestBody Customer customer) {
		 cs.deleteCustomer(customer);
	}
	
}
