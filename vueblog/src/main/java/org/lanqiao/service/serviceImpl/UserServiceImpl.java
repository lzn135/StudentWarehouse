package org.lanqiao.service.serviceImpl;

import org.lanqiao.entity.User;
import org.lanqiao.mapper.UserMapper;
import org.lanqiao.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyds
 * @since 2021-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
