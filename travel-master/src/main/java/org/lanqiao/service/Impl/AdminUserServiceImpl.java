package org.lanqiao.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lanqiao.mapper.AdminUserMapper;
import org.lanqiao.pojo.AdminUser;
import org.lanqiao.service.AdminUserService;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
}
