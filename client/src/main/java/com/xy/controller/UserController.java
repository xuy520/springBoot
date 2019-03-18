package com.xy.controller;

import com.xy.model.User;
import com.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: UserController
 * @Description:
 * @date 2019/1/15 19:46
 * Copyright (c) CSII.
 * All Rights Reserved.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/userAdd.do")
    @ResponseBody
    public String addUser() {
        return userService.sayHello();
    }


    @RequestMapping("/login.do")
    public String login() {

        return "/login";
    }

    @RequestMapping("/index.do")
    public String index() {

        return "/index";
    }


    @RequestMapping("/deny.do")
    public String deny() {

        return "/deny";
    }
}
