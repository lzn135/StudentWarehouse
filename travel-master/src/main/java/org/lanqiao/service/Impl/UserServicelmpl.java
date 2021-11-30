package org.lanqiao.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lanqiao.mapper.UserMapper;
import org.lanqiao.pojo.User;
import org.lanqiao.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl extends ServiceImpl<UserMapper, User> implements UserService {
}
