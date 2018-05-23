package com.exerciseV1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.exerciseV1.model.Product;

public class ProductRowMapper implements RowMapper<Product>{
	 
	@Override
	    public Product mapRow(ResultSet rs, int i) throws SQLException {
	     return new Product( rs.getInt("id"), 
	                         rs.getString("name"), 
	                         rs.getDouble("price"),
	                         rs.getInt("categorypath"), 
	                         rs.getBoolean("available"));
	    }
	
	
}
