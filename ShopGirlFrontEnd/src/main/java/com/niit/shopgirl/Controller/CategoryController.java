package com.niit.shopgirl.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shopgirlbackend.dao.CategoryDAO;
import com.niit.shopgirlbackend.model.Category;
@Controller
public class CategoryController {
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@RequestMapping(value="/manageAllCategories",  method = RequestMethod.GET)
	public String myCategories(Model model){
		System.out.println("manageCategories");
		log.debug("Starting of the method: myCategories");
		model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("isAdminClickedCategories","true");
		log.debug("Ending of the method: myCategories");
		return "/home";
	}
	
	@RequestMapping(value="/manageCategoryAdd" ,method= RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model){
	log.debug("Starting of the method: addCategory");
	log.debug("id:"+category.getId());
	if(categoryDAO.saveOrUpdate(category)==true)
	{
		model.addAttribute("msg","Successfully added category");
	}
	else
	{
		model.addAttribute("msg","Not able to add category");
	}
	model.addAttribute("category", category);
	model.addAttribute("categoryList",categoryDAO.list());
	model.addAttribute("isAdminClickedCategories", "true");
	log.debug("Ending of the method: addCategory");
	return "/home";
	}
	
	@RequestMapping("manageCategoryRemove/{id}")
	public String removeCategory(@PathVariable("id") String id, Model model) throws Exception{
		log.debug("Starting of the method: removeCategory");
		boolean flag = categoryDAO.delete(id);
		String msg = "Successfully removed category";
		if(flag != true){
			msg = "Not able to remove category";
		}
		model.addAttribute("msg", msg);
		log.debug("Ending of the method: removeCategory");
		return "forward:/manageAllCategories";
		
	}
	
	@RequestMapping("manageCategoryEdit/{id}")
	public String editCategory(@PathVariable("id") String id,Model model){
		//categoryDAO.saveOrUpdate(category);
		System.out.println("in edit");
		log.debug("Starting of the method: editCategory");
		category = categoryDAO.get(id);
		model.addAttribute("category", category);
		log.debug("Ending of the method editCategory");
		return "forward:/manageAllCategories";
	}
	
	
	

}
