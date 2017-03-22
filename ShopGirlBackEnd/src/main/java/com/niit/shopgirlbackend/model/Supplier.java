package com.niit.shopgirlbackend.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="SUPPLIER")
@Component
public class Supplier implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@Max(20)
	private String id;
	
	@NotEmpty
	@Max(50)
	private String name;
	
	@NotBlank
	@Max(50)
	private String address;
	
	@OneToMany(mappedBy="supplier" , fetch = FetchType.EAGER)
	private Set<Product> products;
	
	@OneToMany(mappedBy="supplier" , fetch = FetchType.EAGER)
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
