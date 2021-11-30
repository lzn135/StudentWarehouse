package com.lou.springboot.config;


import com.lou.springboot.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

	@Resource
	AdminLoginInterceptor adminLoginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//创建拦截器类
		InterceptorRegistration interceptor = registry.addInterceptor(adminLoginInterceptor);
		interceptor.addPathPatterns("/admin/**")
				.excludePathPatterns("/admin/login")
				.excludePathPatterns("/resources/plugins")
				.excludePathPatterns("/resources/dist");

		//注册拦截器类，添加黑名单(addPathPatterns("/**")),‘/*’只拦截一个层级，'/**'拦截全部
		// 和白名单(excludePathPatterns("List类型参数"))，将不必拦截的路径添加到List列表中


	}
}