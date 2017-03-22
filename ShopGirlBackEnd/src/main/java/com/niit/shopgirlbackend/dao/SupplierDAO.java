package com.niit.shopgirlbackend.dao;


import java.util.List;

import com.niit.shopgirlbackend.model.Supplier;


public interface SupplierDAO {


	public List<Supplier> list();
	
	public Supplier get(String id);
	
	public Supplier getByName(String name);
	
	public boolean saveOrUpdate(Supplier supplier);
	
	public boolean delete(String id);
}
