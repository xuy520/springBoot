package com.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: ServerController
 * @Description:
 * @date 2018/12/13 20:45
 * Copyright (c) CSII.
 * All Rights Reserved.
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerController {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ServerController.class).web(true).run(args);
    }
}
