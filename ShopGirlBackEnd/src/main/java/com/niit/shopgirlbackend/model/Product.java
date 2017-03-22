package com.niit.shopgirlbackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")
@Component
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	private String productID;
	
	@NotEmpty 
	private String name;
	
	@NotNull 
	private String description;
	
	@NotNull 
	private String categoryID;
	
	@NotNull 
	private String supplierID;
	 
	@NotNull
	@Column(length = 8, precision = 2)
	private double price;

	@NotNull
	private String size;
	
	@NotNull
	private int stock;
	

	@ManyToOne
	@JoinColumn(name = "categoryID", updatable= false, insertable= false, nullable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "supplierID", updatable= false, insertable= false, nullable=false)
	private Supplier supplier;
	
	@Transient
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@ManyToOne
	@JoinColumn(name = "categoryID", updatable= false, insertable= false, nullable=false)
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@ManyToOne
	@JoinColumn(name = "categoryID", updatable= false, insertable= false, nullable=false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	}