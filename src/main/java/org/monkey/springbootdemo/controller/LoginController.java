package org.monkey.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.monkey.springbootdemo.common.dto.Result;
import org.monkey.springbootdemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginController
 *
 * @author cc
 * @since 2024/10/14 10:41
 */
//
@Slf4j
@Controller
public class LoginController {

    // 在 @RestController时使用 需要返回试图对象
    /*@RequestMapping("/login")
    public ModelAndView login(String error) {
        log.info("/login");
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("error", error);
        return modelAndView;
    }*/

    // 在 @Controller时使用 可以直接返回字符串
    @RequestMapping("/login")
    public String login(String error) {
        log.info("/login");
        return "login";
    }
}
