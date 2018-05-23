package com.exerciseV1.service;

import java.util.List;


import com.exerciseV1.model.Product;
import com.exerciseV1.model.ProductInfo;


public interface ProductService {
	public List<Product> getAllProducts();
	public List<ProductInfo> getAllProductInfo();
	public void deleteProduct(Integer id);
	public Product findProduct(Integer id);
	public void updateProduct(Product product);
	public void insert(Product product);
}
