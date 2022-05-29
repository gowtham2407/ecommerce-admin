package com.home.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.bean.AdminBean;
import com.home.dao.AdminDAO;
import com.home.dao.CategoryAndBrandDAO;
import com.home.model.CategoryAndBrandBean;

@Controller
public class FirstController {
	
	@Autowired
	CategoryAndBrandDAO categoryAndBrandDAO;
	
	@Autowired
	AdminDAO adminDAO;
	
	
	@RequestMapping("/first")
	public String check() {
		System.out.println("entering");
		return "test";
	}
	
	@RequestMapping("/login")
	public String getLoginPage() {
		System.out.println("getLoginPage()");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@ModelAttribute AdminBean adminBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("login");
		AdminBean loggedInUser = adminDAO.login(adminBean);
		System.out.println(loggedInUser);
		HttpSession session = request.getSession();
		session.setAttribute("loggedInUser", loggedInUser);
		System.out.println("1 ----" + request.getAttribute("loggedInUser"));
		response.sendRedirect("/home.com/updateCategoryAndBrand");
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("loggedInUser");
		System.out.println("2 ----" + request.getAttribute("loggedInUser"));
		response.sendRedirect("/home.com/login");
	}
	
	@RequestMapping("/updateCategoryAndBrand")
	public String updateCategoryAndBrand() {
		System.out.println("updateCategoryAndBrand");
		return "updateCategoryAndBrand";
	}
	
	@RequestMapping("/getCategoryAndBrand")
	@ResponseBody
	public String getCategoryAndBrand() throws JsonProcessingException {
		List<CategoryAndBrandBean> result = categoryAndBrandDAO.getCategoryAndBrand();
		System.out.println(result);
		ObjectMapper objectMapper = new ObjectMapper();
	    String json = objectMapper.writeValueAsString(result);
	    return json;
	}
	
	@RequestMapping(value = "/editCategoryAndBrand", method = RequestMethod.POST)
	public void editCategoryAndBrand(@ModelAttribute CategoryAndBrandBean brand, HttpServletResponse response) throws IOException {
		System.out.println(brand.getBrandName() + " " + brand.getCategory());
		categoryAndBrandDAO.editCategoryAndBrand(brand);
		response.sendRedirect("/home.com/updateCategoryAndBrand");
	}

	@RequestMapping(value = "/newCategoryAndBrand", method = RequestMethod.POST)
	public void newCategoryAndBrand(@ModelAttribute CategoryAndBrandBean brand, HttpServletResponse response) throws IOException {
		categoryAndBrandDAO.newCategoryAndBrand(brand);
		response.sendRedirect("/home.com/updateCategoryAndBrand");
	}
	
	
}
