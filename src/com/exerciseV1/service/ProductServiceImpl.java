package com.exerciseV1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exerciseV1.dao.ProductDAO;
import com.exerciseV1.model.Product;
import com.exerciseV1.model.ProductInfo;

@Service
public class ProductServiceImpl implements ProductService{
	
    @Autowired
	ProductDAO productDAO;
	
    @Transactional
	public List<Product> getAllProducts(){
		return productDAO.getAllProducts();
	};
	
	@Transactional
	public List<ProductInfo> getAllProductInfo(){
		return productDAO.getAllProductInfo();
	};
	
	@Transactional
	public void deleteProduct(Integer id){
		try {
			if(id != null) {
				productDAO.deleteProduct(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	@Transactional
	public Product findProduct(Integer id){
		try {
			if(id != null) {
				return productDAO.findProduct(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	};
	
	@Transactional
	public void updateProduct(Product product) {
		try {
			if(product != null) {
				productDAO.updateProduct(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	public void insert(Product product) {
		try {
			if(product != null) {
				productDAO.insert(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
