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

import com.niit.shopgirlbackend.dao.SupplierDAO;
import com.niit.shopgirlbackend.model.Supplier;
@Controller
public class SupplierController {
private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value="/manageAllSuppliers",  method = RequestMethod.GET)
	public String mySuppliers(Model model){
		log.debug("Starting of the method: mySuppliers");
		model.addAttribute("supplier",supplier);
		model.addAttribute("supplierList",supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers","true");
		log.debug("Ending of the method: mySuppliers");
		return "/home";
	}
	
	@RequestMapping(value="/manageSupplierAdd" ,method= RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, Model model){
	log.debug("Starting of the method: addSupplier");
	log.debug("id:"+supplier.getId());
	if(supplierDAO.saveOrUpdate(supplier)==true)
	{
		model.addAttribute("msg","Successfully added supplier");
	}
	else
	{
		model.addAttribute("msg","Not able to add supplier");
	}
	model.addAttribute("supplier", supplier);
	model.addAttribute("supplierList", supplierDAO.list());
	model.addAttribute("isAdminClickedSuppliers", "true");
	log.debug("Ending of the method: addSupplier");
	return "/home";
	}
	
	@RequestMapping("manageSupplierRemove/{id}")
	public String removeSupplier(@PathVariable("id") String id, Model model) throws Exception{
		log.debug("Starting of the method: removeSupplier");
		boolean flag = supplierDAO.delete(id);
		String msg = "Successfully removed supplier";
		if(flag != true){
			msg = "Not able to remove supplier";
		}
		model.addAttribute("msg", msg);
		log.debug("Ending of the method: removeSupplier");
		return "forward:/manageAllSuppliers";
		
	}
	
	@RequestMapping("manageSupplierEdit/{id}")
	public String editSupplier(@PathVariable("id") String id,Model model){
		//supplierDAO.saveOrUpdate(supplier);
		log.debug("Starting of the method: editSupplier");
		supplier = supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		log.debug("Ending of the method editSupplier");
		return "forward:/manageAllSuppliers";
	}
	
	
}
