package com.eventmanagement.reg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.reg.payloads.ApiResponse;
import com.eventmanagement.reg.payloads.CategoryDto;
import com.eventmanagement.reg.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	//POST - create user
		@PostMapping("/")
		public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
		{
			CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
			return new ResponseEntity<CategoryDto>(createCategoryDto,HttpStatus.CREATED);
		}
		
		//PUT - update user
		@PutMapping("/{categoryId}")                //{categoryID}-->path uri variable
		public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer catid)
		{
			CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catid);
			return ResponseEntity.ok(updatedCategory);
		}
		
		
		//DELETE - delete user
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
		{
			this.categoryService.deleteCategory(categoryId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully", true),HttpStatus.OK);
		}
		
		
		//GET - users get	
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategories()
		{
			return ResponseEntity.ok(this.categoryService.getAllCategories());
		}
		
		//GET - get single user	
			@GetMapping("/{categoryId}")
			public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId)
			{
				return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
			}
		
			
			
	
}
