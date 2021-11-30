package org.lanqiao.web;

import org.lanqiao.Employee;
import org.lanqiao.service.EmployeeService;
import org.lanqiao.service.impl.EmployeeServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//调用service完成查询
			EmployeeService employeeService = new EmployeeServicelmpl();
			List<Employee> employees = employeeService.findALlEmployee();
			//2.将Emplyoees存入request域
			request.setAttribute("employees", employees);
			//3.转发list.jsp
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
