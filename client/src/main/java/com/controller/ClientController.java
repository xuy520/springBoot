package com.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: ClientController
 * @Description:
 * @date 2018/12/13 20:45
 * Copyright (c) CSII.
 * All Rights Reserved.
 */
@EnableEurekaClient
@SpringBootApplication
public class ClientController {
    public static void main(String[] args) {
        SpringApplication.run(ClientController.class, args);
    }

}
