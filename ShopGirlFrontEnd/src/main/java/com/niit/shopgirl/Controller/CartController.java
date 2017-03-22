package com.niit.shopgirl.Controller;



import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopgirlbackend.dao.CartDAO;
import com.niit.shopgirlbackend.dao.ProductDAO;

import com.niit.shopgirlbackend.model.Cart;
import com.niit.shopgirlbackend.model.Product;


@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;
	
	
	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model) {
		log.debug("Starting of the method myCart");
		model.addAttribute("myCart", new Cart());
		// get the logged-in user id
		String loggedInUserid = (String) session.getAttribute("loggedInUserId");
		log.info("userId"+loggedInUserid);

		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
		}

		int cartSize = cartDAO.list(loggedInUserid).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUserid));
			model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("showMyCart", "true");

		}
		log.debug("Ending of the method myCart");
		return "/home";
	}

	// For add and update myCart both
	@RequestMapping(value = "/myCartAdd/{productID}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("productID") String productID) {
		log.debug("Starting of the method addToCart");
		// get the product based on product id
		Product product = productDAO.get(productID);
		cart.setPrice(product.getPrice());
		cart.setProductName(product.getName());
		String loggedInUserID = (String) session.getAttribute("loggedInUserId");
		if (loggedInUserID == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserID = auth.getName();
		}
		cart.setUserID(loggedInUserID);
		//It is not required if you given default value while creating the table
		cart.setStatus("NEW"); // Status is New. Once it is dispatched, we can
								// changed to 'D'
		
		//To get sequence number, you can do programmatically in DAOImpl
		cart.setDateAdded(new Date());
		cart.getQuantity();
		cart.setProductID(product.getProductID());
		

		
		cartDAO.saveOrUpdate(cart);
		//return "redirect:/views/home.jsp";

		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("successMessage", " Successfuly added the product to myCart");
		log.debug("Ending of the method addToCart");
		return mv;

	}
	
	@RequestMapping("myCartRemove/{id}")
	public String removeCart(@PathVariable("id") int id, Model model) throws Exception{
		log.debug("Starting of the method: removeCart");
		try {
			cartDAO.delete(id);
			model.addAttribute("message", "Successfully Removed");
		} catch (Exception e) {
			model.addAttribute("message",e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("End of the method : removeCart");
		return "forward:/myCart";
	}
	
	
	

	
}

