package com.niit.shopgirlbackend.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ShippingAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String shippingAddressId;
	
	@NotBlank(message="Please Add your Address")
	private String line1;
	private String line2;
	
	@NotBlank(message="Please Add your city")
	private String city;
	
	@NotBlank(message="Please Add your state ")
	private String state;
	
	@NotBlank(message="Please Add your country")
	private String country;
	
	@NotBlank(message="Please Add your zipcode")
	private String zipCode;
	
	@Override
	public String toString() {
		return "ShippingAddress [shippingAddressId=" + shippingAddressId + ", line1=" + line1 + ", line2=" + line2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}

	public String getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
}
