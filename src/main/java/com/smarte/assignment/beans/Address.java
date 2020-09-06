package com.smarte.assignment.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String pincode;
	private String state;
	private String country;
	
	public Address() {}
	
	public Address(String city, String pincode, String state, String country) {
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}
	
	
}
