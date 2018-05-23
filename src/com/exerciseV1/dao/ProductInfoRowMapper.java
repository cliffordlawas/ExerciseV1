package com.exerciseV1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.exerciseV1.model.Category;
import com.exerciseV1.model.Product;
import com.exerciseV1.model.ProductInfo;

public class ProductInfoRowMapper implements RowMapper<ProductInfo>{
	 
	@Override
	    public ProductInfo mapRow(ResultSet rs, int i) throws SQLException {
		 
	     Product p = new Product(rs.getInt("id"), 
	                         rs.getString("name"), 
	                         rs.getDouble("price"),
	                         rs.getInt("categorypath"), 
	                         rs.getBoolean("available"));
	     Category c = new Category(
	    		 	rs.getInt("category_id"),
	    		 	rs.getString("category_name")
	    		 );
	     return new ProductInfo(p,c);
	    }
	
	
}
