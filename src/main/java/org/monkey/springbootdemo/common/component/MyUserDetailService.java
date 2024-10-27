package org.monkey.springbootdemo.common.component;

import lombok.extern.slf4j.Slf4j;
import org.monkey.springbootdemo.common.domain.MyUserDetail;
import org.monkey.springbootdemo.common.exception.GlobalException;
import org.monkey.springbootdemo.domain.User;
import org.monkey.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * MyUserDetailService
 *
 * @author cc
 * @since 2024/10/14 14:03
 */
@Component
@Slf4j
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public MyUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername username:{}", username);
        //在这里可以自己调用数据库，对username进行查询，看看在数据库中是否存在
        if (StringUtils.isEmpty(username)) {
            throw new GlobalException("用户名不能为空");
        }
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        MyUserDetail myUserDetail = new MyUserDetail();
        myUserDetail.setUsername(user.getUsername());
        myUserDetail.setPassword(user.getPassword());
        return myUserDetail;
    }
}
