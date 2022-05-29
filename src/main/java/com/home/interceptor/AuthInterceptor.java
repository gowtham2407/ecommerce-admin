package com.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println(" -------------------- Pre-handle - " + request.getRequestURI() + " " + request.getMethod());
		
		System.out.println("auth interceptor - " + request.getSession().getAttribute("loggedInUser"));
		
		if ("/home.com/login".equals(request.getRequestURI())) {
			return true;
		} else {
			if (request.getSession().getAttribute("loggedInUser") != null) {
				return true;
			} else {
				return false;
			}
		}
	}
}
