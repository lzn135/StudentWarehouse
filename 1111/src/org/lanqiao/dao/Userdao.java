package org.lanqiao.dao;

import org.lanqiao.User;

import java.sql.SQLException;

public interface Userdao {
	public User findUserByUsernameAndPassword(User user) throws SQLException;
}
