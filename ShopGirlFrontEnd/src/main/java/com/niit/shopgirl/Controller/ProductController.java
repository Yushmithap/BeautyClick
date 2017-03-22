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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shopgirl.util.FileUtil;
import com.niit.shopgirlbackend.dao.CategoryDAO;
import com.niit.shopgirlbackend.dao.ProductDAO;
import com.niit.shopgirlbackend.dao.SupplierDAO;
import com.niit.shopgirlbackend.model.Category;
import com.niit.shopgirlbackend.model.Product;
import com.niit.shopgirlbackend.model.Supplier;
@Controller
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	private String path = "C:\\Users\\Manisha\\Desktop\\BeautyClick\\ShopGirl\\src\\main\\webapp\\img\\";
	
	
	
	
	@RequestMapping(value="/manageAllProducts",  method = RequestMethod.GET)
	public String myProducts(Model model){
		log.debug("Starting of the method: myProducts");
		model.addAttribute("product",product);
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("isAdminClickedProducts","true");
		log.debug("Ending of the method: myProducts");
		return "/home";
	}
	
	@RequestMapping(value="/manageProductAdd" , method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file ,Model model){
		log.debug("Starting of the method: addProduct");
		Category category = categoryDAO.getByName(product.getCategory().getName());
		Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategoryID(category.getId());
		product.setSupplierID(supplier.getId());
		product.setProductID(com.niit.shopgirl.util.Util.removeComman(product.getProductID()));
		productDAO.saveOrUpdate(product);
		
		FileUtil.upload(path, file, product.getProductID()+".jpg");
		log.debug("End of the method: addProduct");
		model.addAttribute("isAdminClickedProducts","true");
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("product", new Product());
		log.debug("Ending of the method: addProduct");
		return "/home";
		
	}
	@RequestMapping("manageProductRemove/{productID}")
	public String removeProduct(@PathVariable("productID") String productID, Model model) throws Exception{
		log.debug("Starting of the method: removeProduct");
		boolean flag = productDAO.delete(productID);
		String msg = "Successfully removed product";
		if(flag != true){
			msg = "Not able to remove product";
		}
		model.addAttribute("msg", msg);
		log.debug("Ending of the method: removeProduct");
		return "forward:/manageAllProducts";
		
	}
	
	@RequestMapping("manageProductEdit/{productID}")
	public String editProduct(@PathVariable("productID") String productID,Model model){
		//productDAO.saveOrUpdate(product);
		log.debug("Starting of the method: editProduct");
		product = productDAO.get(productID);
		model.addAttribute("product", product);
		log.debug("Ending of the method editProduct");
		return "forward:/manageAllProducts";
	}
	
	@RequestMapping("manageProductGet/{productID}")
	public ModelAndView getSelectedProduct(@PathVariable("productID") String productID, RedirectAttributes redirectAttributes){
		
		log.debug("Start of the method: getSelectedProduct");
		ModelAndView mv = new ModelAndView("redirect:/home");
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(productID));
		log.debug("End of the method: getSelectedProduct");
		return mv;
		
	}
	
	
	
	
	
	
}
