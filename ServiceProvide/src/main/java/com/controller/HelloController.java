package com.controller;

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
public class HelloController {

    @RequestMapping("/hello.do")
    @ResponseBody
    public String hello() {
        System.out.println("服务方提供服务调用");
        return "hello";
    }
}
