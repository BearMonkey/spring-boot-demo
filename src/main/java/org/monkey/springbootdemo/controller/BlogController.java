package org.monkey.springbootdemo.controller;

import org.monkey.springbootdemo.domain.Blog;
import org.monkey.springbootdemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * BlogController
 *
 * @author cc
 * @since 2024/10/23 11:15
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public ModelAndView listBlog() {
        List<Blog> list = blogService.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("blog/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    public ModelAndView addBlog() {
        ModelAndView modelAndView = new ModelAndView();
        Blog blog = new Blog();
        modelAndView.addObject("blog", blog);
        modelAndView.setViewName("blog/add");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getBlog(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Blog blog = blogService.getBlog(id);
        modelAndView.addObject("blog", blog);
        modelAndView.setViewName("blog/detail");
        return modelAndView;
    }
}
