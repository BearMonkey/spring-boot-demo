package org.monkey.springbootdemo.controller;

import org.monkey.springbootdemo.domain.A;
import org.monkey.springbootdemo.domain.User;
import org.monkey.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DemoController
 *
 * @author cc
 * @since 2024/10/10 11:58
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ModelAndView test() {
        System.out.println("/demo/test");
        List<User> list = userService.findAllUsers();
        ModelAndView test = new ModelAndView("test");
        test.addObject("list", list);
        return test;
    }
}

