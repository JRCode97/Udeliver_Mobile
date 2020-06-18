package dev.rivera.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="driver")
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String passWord;
	@OneToMany(mappedBy="driver", fetch=FetchType.LAZY)
	private List<Restaurant> restaurants;
	@OneToMany(mappedBy="driver", fetch=FetchType.LAZY)
	private List<Delivery> deliveries;
	public Driver() {
		super();
	}
	public Driver(int id, String firstName, String lastName, String userName, String passWord,
			List<Restaurant> restaurants, List<Delivery> deliveries) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.restaurants = restaurants;
		this.deliveries = deliveries;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", passWord=" + passWord + ", restaurants=" + restaurants + ", deliveries=" + deliveries + "]";
	}


	
	
	
}
