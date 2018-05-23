package com.exerciseV1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exerciseV1.dao.CategoryDAO;
import com.exerciseV1.dao.ProductDAO;
import com.exerciseV1.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	 @Autowired
	 CategoryDAO categoryDAO;
		
	@Transactional
	public List<Category> getAllCategory() {
		return categoryDAO.getAllCategories();
	}
}
