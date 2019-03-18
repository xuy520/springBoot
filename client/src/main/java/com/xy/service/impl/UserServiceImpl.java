package com.xy.service.impl;

import com.xy.dao.UserRepository;
import com.xy.model.User;
import com.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: UserServiceImpl
 * @Description:
 * @date 2019/1/16 10:27
 * Copyright (c) CSII.
 * All Rights Reserved.
 */

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        if (user != null) {
            User.UserDetail userDetail = user.new UserDetail();
            return userDetail;
        }
        return null;
    }

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

    @Override
    public String sayHello() {
        ServiceInstance sayHello = loadBalanced.choose("sayHelloServer");
        System.out.println("消费方调用服务");
        return restTemplate.getForObject("http://sayHelloServer/user/hello.do", String.class);
    }


}
