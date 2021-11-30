package com.Lmall.service;

import com.Lmall.controller.vo.MallUserVO;
import com.Lmall.entity.MallUser;
import com.Lmall.util.PageQueryUtil;
import com.Lmall.util.PageResult;

import javax.servlet.http.HttpSession;

public interface MallUserService {
    //后台分页
    PageResult getMallUsersPage(PageQueryUtil pageUtil);
    //用户注册
    String register(String loginName, String password);
    //登录
    String login(String loginName, String passwordMD5, HttpSession httpSession);
    //用户修改并更新用户信息
    MallUserVO updateUserInfo(MallUser mallUser, HttpSession httpSession);
    //用户禁用与未禁用(0-未禁用 ， 1-禁用)
    Boolean lockUsers(Integer[] ids, int lockStatus);
}
