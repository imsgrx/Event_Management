package com.eventmanagement.reg.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	
	
	private int categoryId;
	
	@NotEmpty
	@Size(min = 2)
	private String categoryName;
	
	private float categoryPrice;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CategoryDto(String categoryName, float categoryPrice) {
		super();
		this.categoryName = categoryName;
		this.categoryPrice = categoryPrice;
	}



	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public float getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(float categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryPrice="
				+ categoryPrice + "]";
	}
	
	
}
