package org.lanqiao.dao;

import org.lanqiao.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
	List<Employee> findAllEmployee() throws SQLException;
}
