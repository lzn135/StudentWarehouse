package org.lanqiao.service;

import org.lanqiao.User;

import java.sql.SQLException;

public interface UserService {
	public User finUserByUsernameAndPassword(User user) throws SQLException;

}
