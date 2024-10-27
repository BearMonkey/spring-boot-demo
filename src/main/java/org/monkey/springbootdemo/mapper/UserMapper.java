package org.monkey.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import org.monkey.springbootdemo.domain.User;

/**
 * UserMapper
 *
 * @author cc
 * @since 2024/10/15 16:04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
