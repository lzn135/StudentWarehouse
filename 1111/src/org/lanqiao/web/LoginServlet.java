package org.lanqiao.web;


import org.lanqiao.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//1.设置编码
			request.setCharacterEncoding("utf-8");
			//2.获取数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//2.1获取用户验证码
			String imgcode = request.getParameter("imgcode");
			//2.2获取session域中验证码
			String code = (String) request.getSession().getAttribute("code");
			//2.3比较验证码
			if (!code.equalsIgnoreCase(imgcode)) {
				//验证码错误
				//提示信息
				//跳转Login
				request.setAttribute("msg", "验证码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);

				return;
			}
			//3.封装User对象

			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			//4.调用service层
			UserService userService = new UserServicelmpl();
			User result = userService.finUserByUsernameAndPassword(user);


			if (result == null) {
				//登录失败
				//提示信息
				//跳转login
				request.setAttribute("msg", "用户名/密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				//传递用户名
				//跳转index.jsp
				request.getSession().setAttribute("user", result);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//5.判断登录成功
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
