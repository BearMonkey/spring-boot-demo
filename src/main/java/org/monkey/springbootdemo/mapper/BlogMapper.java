package org.monkey.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.monkey.springbootdemo.domain.Blog;

/**
 * BlogMapper
 *
 * @author cc
 * @since 2024/10/23 11:13
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
}
