package com.home.model;


import org.springframework.stereotype.Component;

@Component
public class CategoryAndBrandBean {
	String category;
	String brandName;
	int brandid;

	public CategoryAndBrandBean() {
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	
//	public String toString() {
//		return String.valueOf(this.brandid) + " " + this.brandName + " " + this.category;
//	}
}
