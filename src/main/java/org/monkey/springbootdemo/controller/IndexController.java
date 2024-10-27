package org.monkey.springbootdemo.controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.monkey.springbootdemo.domain.Blog;
import org.monkey.springbootdemo.domain.User;
import org.monkey.springbootdemo.service.BlogService;
import org.monkey.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * DemoController
 *
 * @author cc
 * @since 2024/10/10 11:58
 */
@Controller
@Slf4j
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/index")
    public ModelAndView test() {
        log.info("index");
        List<Blog> list = blogService.listTop10();
        log.info("index top10 blog: {}", JSONObject.toJSONString(list));
        ModelAndView index = new ModelAndView("index");
        index.addObject("list", list);
        return index;
    }
}

