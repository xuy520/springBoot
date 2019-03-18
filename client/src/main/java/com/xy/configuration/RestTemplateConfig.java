package com.xy.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: RestTemplateConfig
 * @Description:
 * @date 2019/3/18 11:40
 * Copyright (c) CSII.
 * All Rights Reserved.
 */

@Configuration
@ComponentScan(value = "com.**")
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
