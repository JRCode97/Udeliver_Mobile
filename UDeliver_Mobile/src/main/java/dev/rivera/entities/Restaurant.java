package dev.rivera.entities;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="restaurant_name")
	private String Name;
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	@OneToMany(mappedBy="restaurant", fetch=FetchType.LAZY)
	private List<Delivery> deliveries;
	@ManyToMany
	@JoinTable(name="restaurant_customer",
	joinColumns={@JoinColumn(name="restaurant_id")},
	inverseJoinColumns = {@JoinColumn (name="customer_id")})
	@JsonIgnore
	private Set<Customer> customers = new TreeSet<Customer>();
	public Restaurant() {
		super();
	}
	public Restaurant(int id, String name, Driver driver, List<Delivery> deliveries, Set<Customer> customers) {
		super();
		this.id = id;
		Name = name;
		this.driver = driver;
		this.deliveries = deliveries;
		this.customers = customers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	//@JsonBackReference
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	//@JsonManagedReference
	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", Name=" + Name + ", driver=" + driver + ", deliveries=" + deliveries
				+ ", customers=" + customers + "]";
	}
}
