package org.lanqiao.service.impl;

import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.dao.impl.EmployeeDaolmpl;
import org.lanqiao.Employee;
import org.lanqiao.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServicelmpl implements EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaolmpl();

	@Override
	public List<Employee> findALlEmployee() throws SQLException {
		return employeeDao.findAllEmployee();
	}
}
