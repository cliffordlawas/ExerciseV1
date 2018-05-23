package com.exerciseV1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.exerciseV1.model.Product;
import com.exerciseV1.model.ProductInfo;

public class ProductDaoImpl implements ProductDAO{

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void insert(Product product) {
		final String query = "INSERT INTO PRODUCTS ( " 
				+ " name, "
				+ " price, " 
				+ " categorypath, " 
				+ " available "
				+ " ) VALUES (?,?,?,?)";
		
		jdbcTemplate.update(query, new Object[] {
				product.getName(), product.getPrice(), product.getCategoryPath(), product.isAvailable()	
		});
	}

	public List<Product> getAllProducts() {
		final String query = "SELECT * FROM PRODUCTS";
		List<Product> result = jdbcTemplate.query(query, new ProductRowMapper());
		return result;
	}

	public List<ProductInfo> getAllProductInfo() {
		final String query = "SELECT *\r\n" + 
				"    FROM products INNER JOIN category ON products.categorypath  = category.category_id;";
		List<ProductInfo> result = jdbcTemplate.query(query, new ProductInfoRowMapper());
		return result;
	}

	public void deleteProduct(Integer id) {
		final String query = "DELETE FROM PRODUCTS WHERE id = ?";
		jdbcTemplate.update(query, new Object[]  { id });
		
	}
	
	public Product findProduct(Integer id) {
		final String query = "SELECT * FROM PRODUCTS where id = ?";
		Product result = null;
		try {
		result= (Product) jdbcTemplate.queryForObject(query, new Object[]  { id }, new BeanPropertyRowMapper(Product.class));
		}catch(EmptyResultDataAccessException e) {}
		return result;
	}
	
	public void updateProduct(Product product) {
		final String query = "UPDATE PRODUCTS SET " 
				+ " name = ?, "
				+ " price = ?," 
				+ " categorypath = ?, " 
				+ " available = ? "
				+ " where id = ?";
		jdbcTemplate.update(query,  new Object[] {product.getName(), product.getPrice(), product.getCategoryPath(), product.isAvailable(),
				product.getId()
				});
	}
	
}
