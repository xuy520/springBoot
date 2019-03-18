package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: com.xy.Application
 * @Description:
 * @date 2019/1/15 19:38
 * Copyright (c) CSII.
 * All Rights Reserved.
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
