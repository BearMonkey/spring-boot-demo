package org.monkey.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.monkey.springbootdemo.domain.Blog;
import org.monkey.springbootdemo.mapper.BlogMapper;
import org.monkey.springbootdemo.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * BlogServiceImpl
 *
 * @author cc
 * @since 2024/10/23 11:14
 */
@Service
@Slf4j
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Override
    public List<Blog> listAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<Blog> listTop10() {
        log.info("listTop10");
        LambdaQueryWrapper<Blog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Blog::getCreateTime);
        queryWrapper.last("limit 10");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Blog getBlog(Integer id) {
        log.info("getBlog {}", id);
        LambdaQueryWrapper<Blog> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Blog::getId, id);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public void addBlog(Blog blog) {
        baseMapper.insert(blog);
    }
}
