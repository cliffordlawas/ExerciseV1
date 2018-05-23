package com.exerciseV1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.exerciseV1.model.Category;
import com.exerciseV1.model.Product;

public class CategoryRowMapper implements RowMapper<Category>{
	@Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
     return new Category( rs.getInt("category_id"), rs.getString("category_name"));
    }
}
