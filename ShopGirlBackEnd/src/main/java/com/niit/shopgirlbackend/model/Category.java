package com.niit.shopgirlbackend.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CATEGORY")
@Component
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@NotEmpty
	private String description;
	
	@OneToMany(mappedBy="category" , fetch = FetchType.EAGER)
	private Set<Product> products;
	
	@OneToMany(mappedBy="category" , fetch = FetchType.EAGER)
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
