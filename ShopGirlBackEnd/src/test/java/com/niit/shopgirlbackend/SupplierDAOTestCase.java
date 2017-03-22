package com.niit.shopgirlbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shopgirlbackend.dao.SupplierDAO;
import com.niit.shopgirlbackend.model.Supplier;

import junit.framework.Assert;

public class SupplierDAOTestCase {

	@Autowired
	static SupplierDAO supplierDAO;
	
	@Autowired
	static Supplier supplier;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopgirlbackend");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO  = (SupplierDAO) context.getBean("supplierDAOImpl");
	}
	

	@Test
	public void getSupplierTestCase()
	{
		supplier = supplierDAO.get("SUPSLY06");
		Assert.assertNotNull("get supplier by id", supplier);
	}
	

	@Test
	public void getSupplierTestCase2()
	{
		supplier = supplierDAO.getByName("UniStand");
		Assert.assertNotNull("get Supplier by name", supplier);
	}
	

	@Test
	public void getAllSupplierTestCase(){
		int size = supplierDAO.list().size();
		Assert.assertEquals("get all suppliers", 6, size);
	}
	
	

	@Test
	public void saveOrUpdateTestcase(){
		supplier.setId("SUPUS01");
		supplier.setName("UniStand");
		supplier.setAddress("India");
		Assert.assertEquals("save Test Case", true, supplierDAO.saveOrUpdate(supplier));
	}
	
	

	@Test
	public void deleteSupplierTest(){
		Assert.assertEquals("delete test case", true, supplierDAO.delete("SUPUNS01"));
	}
	
	
	

	

}
