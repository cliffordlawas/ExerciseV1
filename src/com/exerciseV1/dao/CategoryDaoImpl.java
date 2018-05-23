package com.exerciseV1.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.exerciseV1.model.Category;
import com.exerciseV1.model.Product;

public class CategoryDaoImpl implements CategoryDAO{


	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Category> getAllCategories() {
		final String query = "SELECT * FROM CATEGORY";
		List<Category> result = jdbcTemplate.query(query, new CategoryRowMapper());
		return result;
	}
	
	
	
}
