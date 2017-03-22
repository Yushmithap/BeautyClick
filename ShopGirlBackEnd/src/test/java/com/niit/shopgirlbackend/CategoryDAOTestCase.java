package com.niit.shopgirlbackend;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopgirlbackend.dao.CategoryDAO;
import com.niit.shopgirlbackend.model.Category;

import junit.framework.Assert;


public class CategoryDAOTestCase {

	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static Category category;

	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopgirlbackend");
		context.refresh();
		
		category = (Category) context.getBean("category");
		categoryDAO  = (CategoryDAO) context.getBean("categoryDAOImpl");
	}
	
	@Test
	public void getCategoryTestByID()
	{
		category = categoryDAO.get("BWS01");
		Assert.assertNotNull("get category by id", category);
	}
	
	
	@Test
	public void getCategoryTestByName()
	{
		category = categoryDAO.getByName("Body Wash and Scrub");
		Assert.assertNotNull("get category by name", category);
	}
	
	
	
	@Test
	public void getAllCategoryTestCase(){
		int size = categoryDAO.list().size();
		Assert.assertEquals("get all categories", 11, size);
	}
	
	
	@Test
	public void saveOrUpdateCategoryTest(){
		category.setId("SOAMP5");
		category.setName("Soamp Cream");
		category.setDescription("This product cream is used as night applying cream");
		Assert.assertEquals("save or update Test Case", true, categoryDAO.saveOrUpdate(category));
	}
	
	
	
	@Test
	public void deleteCategoryTest(){
		Assert.assertEquals("delete test case", true, categoryDAO.delete("SOAMP5"));
	}
	

}
