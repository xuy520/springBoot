package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: HelloService
 * @Description:
 * @date 2019/3/18 11:41
 * Copyright (c) CSII.
 * All Rights Reserved.
 */

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalanced;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LoadBalancerClient getLoadBalanced() {
        return loadBalanced;
    }

    public void setLoadBalanced(LoadBalancerClient loadBalanced) {
        this.loadBalanced = loadBalanced;
    }

    public String sayHello() {
        ServiceInstance sayHello = loadBalanced.choose("sayHelloServer");
        System.out.println(restTemplate.getForObject("http://sayHelloServer/user/addUser.do", String.class));
        return restTemplate.getForObject("http://sayHelloServer/user/addUser.do", String.class);
    }
}
