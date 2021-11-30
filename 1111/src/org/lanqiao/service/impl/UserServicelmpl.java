package org.lanqiao.service.impl;

import org.lanqiao.dao.Userdao;
import org.lanqiao.dao.impl.UserDaolmpl;
import org.lanqiao.User;
import org.lanqiao.service.UserService;

import java.sql.SQLException;

public class UserServicelmpl implements UserService {
	public Userdao userdao = new UserDaolmpl();


	@Override
	public User finUserByUsernameAndPassword(User user) throws SQLException {
		return userdao.findUserByUsernameAndPassword(user);
	}
}
