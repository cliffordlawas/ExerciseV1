package com.exerciseV1.common;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exerciseV1.dao.ProductDAO;
import com.exerciseV1.model.Product;

public class App {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
//   	 
//        ProductDAO customerDAO = (ProductDAO) context.getBean("productDAO");
//        Product customer = new Product(1, "EDIT ME",28,"x", false);
//     //   customerDAO.insert(customer);
//        printData(customerDAO.getAllProducts());
//        System.out.println(customer);
//        customerDAO.updateProduct(new Product(1, "EDIT MEss", 100,"x", false));
       // printData(customerDAO.getAllProducts());
	}
	
	private static void printData(List<Product> products) {
		 Iterator it=products.iterator();
		    while(it.hasNext())
		    {
		      Product e=(Product)it.next();
		      System.out.println(e.getId()+" "+e.getName()+" "+e.getPrice());
		    }
	}

}
