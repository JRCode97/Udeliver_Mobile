package dev.rivera.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	@JsonIgnoreProperties({"restaurants"})
	private Driver driver;
	@ManyToMany
	@JoinTable(name="restaurant_customer",
	joinColumns={@JoinColumn(name="restaurant_id")},
	inverseJoinColumns = {@JoinColumn (name="movie_id")})
	@JsonIgnore
	private Set<Customer> customers = new TreeSet<Customer>();
	public Restaurant() {
		super();
	}

	public Restaurant(int id, String name, Driver driver, Set<Customer> customers) {
		super();
		this.id = id;
		Name = name;
		this.driver = driver;
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

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", Name=" + Name + ", driver=" + driver + ", customers=" + customers + "]";
	}

	
}
