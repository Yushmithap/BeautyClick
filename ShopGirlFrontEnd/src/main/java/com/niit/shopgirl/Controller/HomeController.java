package com.niit.shopgirl.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.niit.shopgirlbackend.dao.CategoryDAO;
import com.niit.shopgirlbackend.dao.ProductDAO;
import com.niit.shopgirlbackend.dao.SupplierDAO;
import com.niit.shopgirlbackend.dao.UserDAO;

import com.niit.shopgirlbackend.model.Category;
import com.niit.shopgirlbackend.model.Product;
import com.niit.shopgirlbackend.model.Supplier;
import com.niit.shopgirlbackend.model.User;

@Controller
public class HomeController {

	private static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("homePage", "true");
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);

		session.setAttribute("categoryList", categoryDAO.list());

		session.setAttribute("supplierList", supplierDAO.list());
		
		

		log.debug("Ending of the method onLoad");
		return mv;
	}

	@RequestMapping("/registerHere")
	public ModelAndView registerHere() {
		log.debug("Starting of the method registerHere");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegisterHere", "true");
		log.debug("Ending of the method registerHere");
		return mv;
	}

	@RequestMapping("/loginHere")
	public ModelAndView loginHere() {
		log.debug("Starting of the method loginHere");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("user", user);
		mv.addObject("isUserClickedLoginHere", "true");
		log.debug("Ending of the method loginHere");
		return mv;
	}
	
	@RequestMapping("/home")
	public String reDirectToHome(@ModelAttribute("selectedProduct") final Product selectedProduct, final Model model) {
		log.debug("Starting of the method reDirectToHome");
		model.addAttribute("selectedProduct", selectedProduct);
		
		  model.addAttribute("categoryList", this.categoryDAO.list());
		  model.addAttribute("productList", this.productDAO.list());
		 
		log.debug("Ending of the method reDirectToHome");
		return "/home";
	}
	

}
