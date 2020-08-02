package dev.rivera.services;

import java.util.List;

import dev.rivera.entities.Delivery;

public interface DeliveryServiceI {
	Delivery createDelivery(Delivery delivery);
	
	Delivery getDeliveryById(int id);
	
	List<Delivery> getCustomerDeliveries(Integer customerId);
	
	List<Delivery> getDriverDeliveries(Integer driverId);
	
	List<Delivery> findDeliveriesByDate(int id);
	
	Delivery updateDelivery(Delivery delivery);
	
	void deleteDelivery(Delivery delivery);
	
}
