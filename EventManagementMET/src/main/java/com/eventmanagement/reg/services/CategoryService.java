package com.eventmanagement.reg.services;

import java.util.List;

import com.eventmanagement.reg.payloads.CategoryDto;



public interface CategoryService {
	CategoryDto createCategory(CategoryDto category);
	CategoryDto updateCategory(CategoryDto category,Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategories();
	
	void deleteCategory(Integer categoryId);
}
