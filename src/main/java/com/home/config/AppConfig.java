package com.home.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.home.dao.CategoryAndBrandDAO;

@Configuration
@ComponentScan("com.home")
public class AppConfig {
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce?allowPublicKeyRetrieval=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("king@123");
		return dataSource;
	}
  
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(this.mysqlDataSource());
	}
	
	/*
	 * @Bean public CategoryAndBrandDAO getCategoryAndBrandDAO() { return new
	 * CategoryAndBrandDAO(); }
	 */
	@Bean("viewResolver")
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/views/");
		viewResolve.setSuffix(".jsp");
		return viewResolve;
	}
}
