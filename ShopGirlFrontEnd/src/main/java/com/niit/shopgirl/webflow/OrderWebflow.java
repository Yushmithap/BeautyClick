package com.niit.shopgirl.webflow;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shopgirlbackend.dao.CartDAO;
import com.niit.shopgirlbackend.dao.OrderDAO;
import com.niit.shopgirlbackend.model.BillingAddress;
import com.niit.shopgirlbackend.model.Cart;
import com.niit.shopgirlbackend.model.Order;
import com.niit.shopgirlbackend.model.PaymentMethod;
import com.niit.shopgirlbackend.model.Product;
import com.niit.shopgirlbackend.model.ShippingAddress;
import com.niit.shopgirlbackend.model.User;

@Component
public class OrderWebflow implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(OrderWebflow.class);
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired 
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	Order order;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	Product product;
	
	@Autowired
	User user;
	
	public Order initFlow(){
		log.debug("staring of initflow method");
		
		order = new Order();
		
		log.debug("Ending of initflow method");
		
		return order;
		
	}
	
	public String addShippingAddress(Order order, ShippingAddress shippingAddress)
	{
	log.debug("Staring of Add Shipping address");
	
	order.setShippingAddress(shippingAddress);
	
	log.debug("Ending of add address");
			return "success";
	}
	
	public String addBillingAddress(Order Order, BillingAddress billingAddress)
	{
		log.debug("Staring of Add Billing address");
		
		order.setBillingAddress(billingAddress);
		
		log.debug("Ending of Add Billing address");
		
		return "success";
	}
	
	public String addPaymentMethod(Order order, PaymentMethod paymentMethod)
	{
		log.debug("starting of the method addPaymentMethod");
		log.debug("WEB-INF-->>Starting of the method addPaymentMethod");
		order.getPaymentMethod();
		
		confirmOrder(order);
		
		log.debug("WEB-INF-->>Ending of the method addPaymentMethod");
		 return "success";

	}
	
	public String confirmOrder(Order order)
	{
		log.debug("starting of the method confirmOrder");
		
		order.setUserID(user.getId());
		orderDAO.saveOrUpdate(order);
		
		log.debug("Ending of the method confirmOrder");
		
		return "home";
	}
	
	
}
