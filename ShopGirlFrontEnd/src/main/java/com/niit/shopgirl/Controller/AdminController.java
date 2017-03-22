package com.niit.shopgirl.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopgirlbackend.dao.CategoryDAO;
import com.niit.shopgirlbackend.dao.ProductDAO;
import com.niit.shopgirlbackend.dao.SupplierDAO;
import com.niit.shopgirlbackend.model.Category;
import com.niit.shopgirlbackend.model.Product;
import com.niit.shopgirlbackend.model.Supplier;
@Controller
public class AdminController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
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
	
	@RequestMapping("/manageAllCategories")
	public ModelAndView allCategories(){
		logger.debug("Starting of the method: allCategories");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("category",category);
		mv.addObject("isAdminClickedCategories","true");
		mv.addObject("categoryList",categoryDAO.list());
		logger.debug("Ending of the method: allCategories");
		return mv;
	}
	
	@RequestMapping("/manageAllProducts")
	public ModelAndView allProducts(){
		logger.debug("Starting of the method: allProducts");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isAdminClickedProducts","true");
		mv.addObject("product",product);
		mv.addObject("productList",productDAO.list());
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplier",supplier);
		mv.addObject("supplierList",supplierDAO.list());
		logger.debug("Ending of the method: allProducts");
		return mv;
		
	}
	
	@RequestMapping("/manageAllSuppliers")
	public ModelAndView allSuppliers(){
		logger.debug("Starting of the method: allSuppliers");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("supplier",supplier);
		mv.addObject("isAdminClickedSuppliers","true");
		mv.addObject("supplierList",supplierDAO.list());
		logger.debug("Ending of the method: allSuppliers");
		return mv;
	}
	
}
