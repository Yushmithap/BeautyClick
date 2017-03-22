package com.niit.shopgirlbackend.dao;

import java.util.List;

import com.niit.shopgirlbackend.model.Order;

public interface OrderDAO {
	public List<Order> list(String userID);
	
	public boolean saveOrUpdate(Order order);
	
	public boolean delete(int orderID);
	
	public Order get(String userID);
	
}
