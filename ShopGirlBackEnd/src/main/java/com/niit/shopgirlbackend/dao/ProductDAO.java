package com.niit.shopgirlbackend.dao;

import java.util.List;

import com.niit.shopgirlbackend.model.Product;



public interface ProductDAO {

	public List<Product> list();
	
	public Product get(String id);
	
	public Product getByName(String name);
	
	public boolean saveOrUpdate(Product product);
	
	public boolean delete(String id);
}
