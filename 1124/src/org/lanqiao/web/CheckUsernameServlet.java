package org.lanqiao.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(111);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");

		//调用service层判断用户是否存在
		//{flag:true,msg:"这个名字太受欢迎了"}
		//{flag:false,msg:"用户名可使用"}
		Map<String, Object> map = new HashMap<>();


		if ("孙".equals(username)) {
			//用户名已存在
			map.put("flag", true);
			map.put("msg", "这个名字太受欢迎了");
		} else {
			//不存在
			map.put("flag", false);
			map.put("msg", "用户名可使用");
		}

		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(map);
		System.out.println(result);
		response.getWriter().write(result);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
