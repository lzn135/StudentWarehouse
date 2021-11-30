package org.lanqiao.Realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lanqiao.bean.User;

import javax.management.Query;

public class MyRealm  extends AuthorizingRealm {


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("授权");
		return null;

	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)throws AuthenticationException{
		System.out.println("认证");


		UsernamePasswordToken usertoken = (UsernamePasswordToken)authenticationToken;
		return null;


		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username",usertoken.getUsername());




	}


}
