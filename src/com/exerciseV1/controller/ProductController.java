package com.exerciseV1.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exerciseV1.model.Category;
import com.exerciseV1.model.Product;
import com.exerciseV1.service.CategoryService;
import com.exerciseV1.service.ProductService;
import com.exerciseV1.service.ProductServiceImpl;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
	
    @RequestMapping(
    		value="/all-products",
    		method = RequestMethod.GET,
    	    headers = "Accept=application/json",
    	    produces = "application/json"
    		)
    public List<Product> getAllPlugins() {
    	return productService.getAllProducts();
    }
	
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
    	productService.deleteProduct(id);
    	return "redirect:/product";
	 }
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, ModelMap model){
    	Product products = productService.findProduct(id);
    	List<Category> categories = categoryService.getAllCategory(); 
    	if(products!=null) {
    		model.addAttribute("product",products);
    		model.addAttribute("category",categories);
        	model.addAttribute("type","edit");
        	model.addAttribute("action", "/product/update/");
        	return "product-manage";
    	} else {
    		return "redirect:/404";
    	}
    	
	 }
   
    @RequestMapping(value="/add-new", method = RequestMethod.GET)
    public String add( ModelMap model){
    	Product products = new Product();
    	List<Category> categories = categoryService.getAllCategory(); 
		model.addAttribute("product",products);
		model.addAttribute("category",categories);
    	model.addAttribute("type","add");
    	model.addAttribute("action", "/product/add/");
    	return "product-manage";
	 }
    
    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, Product product, @RequestParam("categorypath") int category){
    	
    	Product products = productService.findProduct(id);
    	if(products!=null) {
    		product.setCategoryPath(category);
    		 productService.updateProduct(product);
    		 return "redirect:/product";
    		 // return "index";
    	} else {
    		return "redirect:/404";
    	}
    	
	 }
    
    
    @RequestMapping(value="/add/{id}", method = RequestMethod.POST)
    public String insert(@PathVariable int id, Product product, @RequestParam("categorypath") int category){
    	product.setCategoryPath(category);
    	productService.insert(product);
    	return "redirect:/product";
    	
	 }
   
    
}
