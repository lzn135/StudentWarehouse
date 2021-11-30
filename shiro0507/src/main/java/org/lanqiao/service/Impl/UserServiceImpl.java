package org.lanqiao.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lanqiao.bean.User;
import org.lanqiao.mapper.UserMapper;
import org.lanqiao.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {
}
