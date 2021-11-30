package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.dao.Userdao;
import org.lanqiao.User;
import org.lanqiao.utils.JDBCUtils;

import java.sql.SQLException;

public class UserDaolmpl implements Userdao {

	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	@Override
	public User findUserByUsernameAndPassword(User user) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		Object[] params = {user.getUsername(), user.getPassword()};
		User query = qr.query(sql, new BeanHandler<User>(User.class), params);
		return query;
	}
}
