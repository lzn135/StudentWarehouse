package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yyds
 * @since 2021-05-14
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}
