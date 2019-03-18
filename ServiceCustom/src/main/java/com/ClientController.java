package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: com.ClientController
 * @Description:
 * @date 2019/3/18 10:17
 * Copyright (c) CSII.
 * All Rights Reserved.
 */


@EnableEurekaClient
@SpringBootApplication
@RestController
public class ClientController {
    public static void main(String[] args) {
        SpringApplication.run(ClientController.class, args);
    }

}
