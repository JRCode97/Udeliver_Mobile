package dev.rivera.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.rivera.entities.Delivery;
import dev.rivera.repositories.CustomerRepository;
import dev.rivera.repositories.DeliveryRepository;
import dev.rivera.repositories.DriverRepository;
@Component
@Service
public class DeliveryService implements DeliveryServiceI {
	@Autowired
	DeliveryRepository dr;
	@Autowired
	CustomerRepository cr;
	@Autowired
	DriverRepository drr;
	@Override
	public Delivery createDelivery(Delivery delivery) {
		return dr.save(delivery);
	}

	@Override
	public Delivery getDeliveryById(int id) {
		return dr.findById(id).get();
	}

	@Override
	public List<Delivery> getCustomerDeliveries(Integer customerId) {
		return dr.findByCustomer(cr.findById(customerId).get());
	}

	@Override
	public List<Delivery> getDriverDeliveries(Integer driverId) {
		return dr.findByDriver(drr.findById(driverId).get());
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		return dr.save(delivery);
	}

	@Override
	public void deleteDelivery(Delivery delivery) {
			dr.delete(delivery);
	}

	@Override
	public List<Delivery> findDeliveriesByDate(int id) {
		Date d = new Date();
		long currentTime = d.getTime();
		return dr.getDeliveries(currentTime-604800000,currentTime+86400000,id);
	}

}
