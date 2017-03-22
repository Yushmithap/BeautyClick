package com.niit.shopgirlbackend.dao;

import java.util.List;

import com.niit.shopgirlbackend.model.Cart;

public interface CartDAO {

	
	public List<Cart> list(String userID);
	
	public boolean saveOrUpdate(Cart cart);
	
	public boolean delete(int id);
	
	public Double getTotalAmount(String userID);
	
	

}
