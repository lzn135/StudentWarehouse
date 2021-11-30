package org.lanqiao.service;

import org.lanqiao.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
	public List<Employee> findALlEmployee() throws SQLException;
}
