package com.exerciseV1.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exerciseV1.model.Product;
import com.exerciseV1.model.ProductInfo;
import com.exerciseV1.service.ProductService;

@Controller
public class ViewController {

    @Autowired
    ProductService productService;
    
    @RequestMapping(value = { "/", "/login**" }, method = RequestMethod.GET)
	public  String index() {
    	return "redirect:/login";
	}
	
	@RequestMapping("/product**")
	public ModelAndView products() {
		List<ProductInfo> products = productService.getAllProductInfo();
		// List<Product> products = productService.getAllProducts();
		return new ModelAndView("product","product", products);
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;
	}
//	
//	//for 403 access denied page
//	@RequestMapping(value = "/403", method = RequestMethod.GET)
//	public ModelAndView accesssDenied() {
//
//	  ModelAndView model = new ModelAndView();
//		
//	  //check if user is login
//	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	  if (!(auth instanceof AnonymousAuthenticationToken)) {
//		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
//		model.addObject("username", userDetail.getUsername());
//	  }
//		
//	  model.setViewName("403");
//	  return model;
//
//	}

}
