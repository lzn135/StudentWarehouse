package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.Employee;
import org.lanqiao.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaolmpl implements EmployeeDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public List<Employee> findAllEmployee() throws SQLException {
		String sql = "select * from Employee";
		List<Employee> list = qr.query(sql, new BeanListHandler<Employee>(Employee.class));
		return list;

	}
}
