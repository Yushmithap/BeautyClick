package com.niit.shopgirlbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopgirlbackend.dao.ProductDAO;
import com.niit.shopgirlbackend.model.Product;

import junit.framework.Assert;


public class ProductDAOTestCase {

	@Autowired
	static ProductDAO productDAO;
	
	@Autowired
	static Product product;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopgirlbackend");
		context.refresh();
		
		product = (Product) context.getBean("product");
		productDAO  = (ProductDAO) context.getBean("productDAOImpl");
	}
	
	
	@Test
	public void getProductTestId()
	{
		product = productDAO.get("PROBODY01");
		Assert.assertNotNull("get product by id", product);
	}
	
	
	@Test
	public void getProductTestName()
	{
		product = productDAO.getByName("MADARA Unisex Natural SkinCare Wild FruitVitalising Body Wash");
		Assert.assertNotNull("get product by name", product);
	}
	
	
	
	
	@Test
	public void getAllProductTestCase(){
		int size = productDAO.list().size();
		Assert.assertEquals("get all products", 4, size);
	}
	
	
	@Test
	public void saveOrUpdateTest(){
		product.setProductID("PROBODY05");
		product.setName("BioBloom Unisex Veltiver");
		product.setDescription("This body wash from BioBloom gives you flawless skin");
		product.setCategoryID("BWS01");
		product.setSupplierID("SUPSLY06");
		product.setPrice(748);
		product.setSize("200ml");
		product.setStock(10);
		Assert.assertEquals("save Test Case", true, productDAO.saveOrUpdate(product));
	}
	
	
	
	
	@Test
	public void deleteTest(){
		Assert.assertEquals("delete test case", true,productDAO.delete("PROBODY5"));
	}
	

}
