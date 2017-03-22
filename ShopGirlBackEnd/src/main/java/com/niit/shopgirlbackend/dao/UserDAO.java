package com.niit.shopgirlbackend.dao;

import java.util.List;

import com.niit.shopgirlbackend.model.User;

public interface UserDAO {
	//write just method declarations that you want to implement it in another class that is in DAO

	public List<User> list();
	
	public boolean saveOrUpdate(User user);
	
	public boolean delete(String id);
	
	public User get(String id);
	
	public User getByName(String name);
	
	public User isValidUser(String id, String password);
		
	
}