package dev.rivera.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="delivery")
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="tip")
	private double tip;
	@Column(name="order_time")
	private long orderTime;
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonIgnoreProperties({"deliveries"})
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="driver_id")
	@JsonIgnoreProperties({"restaurants"})
	private Driver driver;
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	@JsonIgnoreProperties({"driver","deliveries"})
	private Restaurant restaurant;
	public Delivery() {
		super();
	}

	public Delivery(int id, double tip, long orderTime, Customer customer, Driver driver,
			Restaurant restaurant) {
		super();
		this.id = id;
		this.tip = tip;
		this.orderTime = orderTime;
		this.customer = customer;
		this.driver = driver;
		this.restaurant = restaurant;
	}
	//@JsonBackReference
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTip() {
		return tip;
	}
	public void setTip(double tip) {
		this.tip = tip;
	}
	public long getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//@JsonBackReference
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "Delivery [id=" + id + ", tip=" + tip + ", orderTime=" + orderTime + ", customer=" + customer
				+ ", driver=" + driver + "]";
	}
	
}
