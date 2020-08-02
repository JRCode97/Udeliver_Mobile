package dev.rivera.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import dev.rivera.entities.Customer;
import dev.rivera.entities.Driver;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	Customer findByAddressAndZip(String address,String zip);

	@Query(value="select sum(d.tip) from Customer c,Delivery d where c.id = d.customer and c.id=?1")
	Double getCustomerTipTotal(int id);
	@Transactional
	@Query(value="select DISTINCT c from Customer c,Delivery d,Driver dr where d.driver=dr.id and d.customer = c.id and dr.id = ?1")
	List<Customer> findCustomerByDriver(int driverId);
	
	@Transactional
	@Query(value="select AVG(d.tip) from Customer c,Delivery d where c.id = d.customer and c.id=?1")
	Double getCustomerTipAverage(int id);
	
	@Transactional
	@Query(value="select SUM(d.tip) from Customer c,Delivery d,Driver dr where d.driver=dr.id and d.customer = c.id and dr.id = ?1 group by c order by SUM(d.tip) desc ")
	List<Integer> getTopTips(int id);
	
	@Transactional
	@Query(value="select c from Customer c,Delivery d,Driver dr where d.driver=dr.id and d.customer = c.id and dr.id = ?1 group by c order by SUM(d.tip) desc")
	List<Customer> getTopTippers(int id);
	
	@Query(value="select c.city from Customer c, Delivery d, Driver dr where dr.id = d.driver and c.id = d.customer and dr.id = ?1 group by c.city order by SUM(d.tip) desc")
	List<String>getBestTowns(int id);
	
	@Query(value="select SUM(d.tip) from Customer c, Delivery d, Driver dr where dr.id = d.driver and c.id = d.customer and dr.id = ?1 group by c.city order by SUM(d.tip) desc")
	List<Double>getBestTownTips(int id);
	
	@Query(value="select AVG(d.tip) from Delivery d, Customer c,Driver dr where dr.id = d.driver and c.id = d.customer and dr.id = ?1 group by c.address order by AVG(d.tip) desc ")
	List<Double>getBestAvgTip(int id);
	
	@Query(value="select c.address from Delivery d, Customer c,Driver dr where dr.id = d.driver and c.id = d.customer and dr.id=?1 group by c.address order by AVG(d.tip) desc")
	List<String>getBestAvgAddresss(int id);

}
