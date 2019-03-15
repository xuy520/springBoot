package com.xy.oauth2;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author xuyue_2017@csii.com.cn
 * @ClassName: OAuthConfigurer
 * @Description: 授权配置
 * @date 2019/1/18 14:36
 * Copyright (c) CSII.
 * All Rights Reserved.
 */
@Configuration
@EnableAuthorizationServer
public class OAuthConfigurer extends AuthorizationServerConfigurerAdapter {

    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"),
                "tc123456".toCharArray()).getKeyPair("tycoonclient");
        tokenConverter.setKeyPair(keyPair);

        return tokenConverter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("ssoClient").secret("ssoSecret")
                .authorizedGrantTypes("authorization_code", "refresh_token").scopes("openid");
    }
}
