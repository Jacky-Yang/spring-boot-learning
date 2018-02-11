package com.jacky.springboot.learning.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BasePathInterceptor extends HandlerInterceptorAdapter {
	
	public BasePathInterceptor() {
		System.out.println("new BasePathInterceptor()");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView)
			throws Exception {
		String basePath = request.getContextPath();
		String scheme = request.getScheme();
		
		request.setAttribute("basePath", basePath);
		request.setAttribute("baseUrl", scheme + "://" + request.getServerName() + ":" + request.getServerPort());
		
		System.out.println("postHandle");
	}
}
