package org.monkey.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.monkey.springbootdemo.common.enums.CommonError;
import org.monkey.springbootdemo.common.exception.GlobalException;
import org.monkey.springbootdemo.domain.User;
import org.monkey.springbootdemo.mapper.UserMapper;
import org.monkey.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author cc
 * @since 2024/10/15 16:06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new GlobalException(CommonError.ERR_PARAM.getCode(), "用户名不能为空");
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<User> findAllUsers() {
        return baseMapper.selectList(null);
    }
}
