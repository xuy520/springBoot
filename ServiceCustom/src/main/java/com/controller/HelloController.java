package com.controller;

import com.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    private HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hello.do")
    public String deny() {

        return helloService.sayHello();
    }
}
