package com.eventmanagement.reg.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name = "category_name", length = 20,nullable = false)
	private String categoryName;
	
	@Column(name = "category_price")
	private float categoryPrice;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String categoryName, float categoryPrice) {
		super();
		this.categoryId = categoryId;
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
	
	
}
