package com.niit.shopgirlbackend;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopgirlbackend.dao.CartDAO;
import com.niit.shopgirlbackend.model.Cart;
import com.niit.shopgirlbackend.model.Product;

import junit.framework.Assert;

public class CartDAOTestCase {

	@Autowired
	static CartDAO cartDAO;
	
	@Autowired
	static Cart cart;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopgirlbackend");
		context.refresh();
		
		cart = (Cart) context.getBean("cart");
		cartDAO  = (CartDAO) context.getBean("cartDAOImpl");
	}
	
	@Test
	public void getAllCartTestCase(){
		
		int size = cartDAO.list("niit").size();
		Assert.assertEquals("get all cart items", 1, size);
	}
	
	@Test
	public void deleteCartTest(){
		Assert.assertEquals("delete test case", true, cartDAO.delete(cart.getId()));
	}
	
	@Test
	public void getTotalTestCase(){
		
		Double total = cartDAO.getTotalAmount("yush");
	Assert.assertNotNull("Total amount", total);
	}
	
	
	
	
	@Test
	public void saveOrUpdateCartTest(){
		
		cart.setProductName("Beverly Polo Hills Women Body Wash");
		cart.setProductID("PROBODY01");
		cart.setUserID("yush");
		cart.setPrice(239);
		cart.setQuantity(7);
		cart.setStatus("NEW");
		cart.setDateAdded(new Date());
		Assert.assertEquals("save Test Case", true, cartDAO.saveOrUpdate(cart));
	}
	
	
	
	
	
	
	
}
