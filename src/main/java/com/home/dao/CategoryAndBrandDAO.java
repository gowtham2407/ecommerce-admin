package com.home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.home.model.CategoryAndBrandBean;

@Component
public class CategoryAndBrandDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<CategoryAndBrandBean> getCategoryAndBrand() {
		String sql = "SELECT * FROM brand";
		List<CategoryAndBrandBean> result = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<CategoryAndBrandBean>(CategoryAndBrandBean.class));
		return result;
	}

	public void editCategoryAndBrand(CategoryAndBrandBean brand) {
		System.out.println(brand.toString());
		String EDIT_QUERY = "UPDATE brand SET category=?, brandname=? WHERE brandid=?";
		jdbcTemplate.update(EDIT_QUERY, brand.getCategory(), brand.getBrandName(), brand.getBrandid());
		
	}

	public void newCategoryAndBrand(CategoryAndBrandBean brand) {
		String INSERT_QUERY = "INSERT INTO brand (category, brandname) VALUES (?, ?)";
		jdbcTemplate.update(INSERT_QUERY, brand.getCategory(), brand.getBrandName());
	}
}
