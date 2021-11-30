package com.lou.springboot.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AdminLoginInterceptor  implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//如果session中的uid为空，就说明还没有登录，则重定向到登录页面，阻止进入其他页面。
		//false:阻止；true:放行。
		String requestURI = request.getRequestURI();
		if (requestURI.startsWith("/admin") && null == request.getSession().getAttribute("loginUser")) {
			//存储错误路径
			request.getSession().setAttribute("errorMsg", "请登录");
			//重定向到登陆界面
			response.sendRedirect(request.getContextPath() + "/adminlogin");
			return false;
		} else {
			request.getSession().removeAttribute("errorMsg");

			return true;
		}
	}
}
