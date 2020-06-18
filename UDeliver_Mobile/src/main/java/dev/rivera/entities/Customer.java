package dev.rivera.entities;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zip")
	private String zip;
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
	private List<Delivery> deliveries;
	@ManyToMany(mappedBy="customers")
	private Set<Restaurant> restaurants = new TreeSet<Restaurant>();
	public Customer() {
		super();
	}
	public Customer(int id, String address, String city, String state, String zip, List<Delivery> deliveries,
			Set<Restaurant> restaurants) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.deliveries = deliveries;
		this.restaurants = restaurants;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", deliveries=" + deliveries + ", restaurants=" + restaurants + "]";
	}
	
}
