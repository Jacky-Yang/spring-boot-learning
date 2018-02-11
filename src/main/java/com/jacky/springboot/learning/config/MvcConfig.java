package com.jacky.springboot.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jacky.springboot.learning.interceptor.BasePathInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(basePathInterceptor());
	}
	
	@Bean
	public HandlerInterceptor basePathInterceptor() {
		return new BasePathInterceptor();
	}
}
