package dev.rivera.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

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
	private LocalDateTime orderTime;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	public Delivery() {
		super();
	}

	public Delivery(int id, double tip, LocalDateTime orderTime, Customer customer, Driver driver,
			Restaurant restaurant) {
		super();
		this.id = id;
		this.tip = tip;
		this.orderTime = orderTime;
		this.customer = customer;
		this.driver = driver;
		this.restaurant = restaurant;
	}

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
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
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
