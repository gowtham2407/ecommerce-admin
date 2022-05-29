package com.home.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.home.bean.AdminBean;

@Component
public class AdminDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public AdminBean login(AdminBean adminBean) {
		String sql = "SELECT * FROM users WHERE email=?";
		AdminBean adminBeanRes = jdbcTemplate.queryForObject(sql, new Object[] { adminBean.getEmail() },
				new BeanPropertyRowMapper<AdminBean>(AdminBean.class));
		System.out.println(adminBeanRes);
		return adminBeanRes;
	}
}
