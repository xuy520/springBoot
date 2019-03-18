package com.xy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: SecurityConfiguration
 * @Description:
 * @date 2019/1/16 17:11
 * Copyright (c) CSII.
 * All Rights Reserved.
 */

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    public MyFilterSecurityInterceptor getMyFilterSecurityInterceptor() {
        return myFilterSecurityInterceptor;
    }

    public void setMyFilterSecurityInterceptor(MyFilterSecurityInterceptor myFilterSecurityInterceptor) {
        this.myFilterSecurityInterceptor = myFilterSecurityInterceptor;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/image/**", "/user/login.do").permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage("/user/login.do").loginProcessingUrl("/login")
                .defaultSuccessUrl("/user/index.do");
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }


}
