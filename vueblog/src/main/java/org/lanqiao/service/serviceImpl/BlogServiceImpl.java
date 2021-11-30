package org.lanqiao.service.serviceImpl;

import org.lanqiao.entity.Blog;
import org.lanqiao.mapper.BlogMapper;
import org.lanqiao.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
