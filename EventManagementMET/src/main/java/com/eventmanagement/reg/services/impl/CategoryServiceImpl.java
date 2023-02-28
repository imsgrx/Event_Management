package com.eventmanagement.reg.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.reg.entities.Category;
import com.eventmanagement.reg.exceptions.ResourceNotFoundException;
import com.eventmanagement.reg.payloads.CategoryDto;
import com.eventmanagement.reg.repositories.CategoryRepo;
import com.eventmanagement.reg.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.dtoToCategory(categoryDto);
		Category savedCategory = this.categoryRepo.save(category);
		return this.categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
		
		category.setCategoryName(categoryDto.getCategoryName());
		category.setCategoryPrice(categoryDto.getCategoryPrice());
		
		Category updatedCategory = this.categoryRepo.save(category);
		CategoryDto categoryDto2 = this.categoryToDto(updatedCategory);
		return categoryDto2;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map(category->this.categoryToDto(category)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
		this.categoryRepo.delete(category);
		
	}
	
	
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);

		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
