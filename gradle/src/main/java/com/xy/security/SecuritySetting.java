package com.xy.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: SecuritySetting
 * @Description:
 * @date 2019/1/16 16:49
 * Copyright (c) CSII.
 * All Rights Reserved.
 */
@ConfigurationProperties(prefix = "securityconfig")
public class SecuritySetting {
    private String loginSuccessUrl = "/logOut";
    private String permitAll = "/login,/user/login.do";
    private String deniedPage = "/deny";
    private String userRoles;

    public String getLoginSuccessUrl() {
        return loginSuccessUrl;
    }

    public void setLoginSuccessUrl(String loginSuccessUrl) {
        this.loginSuccessUrl = loginSuccessUrl;
    }

    public String getPermitAll() {
        return permitAll;
    }

    public void setPermitAll(String permitAll) {
        this.permitAll = permitAll;
    }

    public String getDeniedPage() {
        return deniedPage;
    }

    public void setDeniedPage(String deniedPage) {
        this.deniedPage = deniedPage;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
}
