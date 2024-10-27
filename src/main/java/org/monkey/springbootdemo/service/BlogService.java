package org.monkey.springbootdemo.service;

import org.monkey.springbootdemo.domain.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BlogService
 *
 * @author cc
 * @since 2024/10/23 11:14
 */
public interface BlogService {

    void addBlog(Blog blog);

    List<Blog> listAll();

    List<Blog> listTop10();

    Blog getBlog(Integer id);
}
