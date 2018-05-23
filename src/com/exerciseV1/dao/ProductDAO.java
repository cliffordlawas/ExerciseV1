package com.exerciseV1.dao;

import java.util.List;

import com.exerciseV1.model.Product;
import com.exerciseV1.model.ProductInfo;

public interface ProductDAO {

	public void insert(Product product);
	public List<Product> getAllProducts();
	public List<ProductInfo> getAllProductInfo();
	public void deleteProduct(Integer id);
	public Product findProduct(Integer id);
	public void updateProduct(Product product);

}
