package org.monkey.springbootdemo.service;

import org.monkey.springbootdemo.domain.User;

import java.util.List;

/**
 * UserService
 *
 * @author cc
 * @since 2024/10/15 16:05
 */
public interface UserService {
    User findUserByUsername(String username);

    List<User> findAllUsers();
}
