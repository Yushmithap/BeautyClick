package com.niit.shopgirlbackend.dao;

import java.util.List;

import com.niit.shopgirlbackend.model.Category;

public interface CategoryDAO {
	
	public List<Category> list();
	
	public Category get(String id);
	
	public Category getByName(String name);
	
	public boolean saveOrUpdate(Category category);
	
	public boolean delete(String id);
	
}
