package dev.rivera.app;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.rivera.repositories.CustomerRepository;
import dev.rivera.repositories.DeliveryRepository;
import dev.rivera.repositories.RestaurantRepository;
import dev.rivera.services.CustomerService;

@SpringBootTest

@ContextConfiguration(classes=dev.rivera.app.UDeliverMobileApplication.class)

class UDeliverMobileApplicationTests {
	@Autowired
	CustomerRepository cr;
	@Autowired
	CustomerService cs;
	@Autowired 
	RestaurantRepository rr;
	@Autowired 
	DeliveryRepository dr;
	@Test
	void getCustomers() {
//		System.out.println(cr.findCustomerByDriver(8));
//		System.out.println(cs.getCustomerByDriverId(8));
//		System.out.println(cr.getCustomerTipAverage(8));
//		System.out.println(cr.getTopTippers(8));
//		Date d = new Date();
//		long currentTime = d.getTime() ;
//		System.out.println(currentTime);
//		System.out.println(currentTime-604800000);
//		System.out.println(new Date());
//		
//		System.out.println(new Date(currentTime -604800000));
////		System.out.println(rr.getTopRestaurants(8));
////		System.out.println(cr.getBestTowns(8));
////		System.out.println(cr.getBestTownTips(8));
//		System.out.println(dr.getDeliveries(currentTime-604800000,currentTime+86400000,8));
	
		System.out.println(cr.getBestAvgAddresss(8));
		System.out.println(cr.getBestAvgTip(8));
	}


}
