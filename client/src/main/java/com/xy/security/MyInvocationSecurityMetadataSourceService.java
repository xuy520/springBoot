package com.xy.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * Created by xuyue on 17/1/19.
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {

    private Map<String, Collection<ConfigAttribute>> map = null;
    private PathMatcher matcher = new AntPathMatcher();

    public PathMatcher getMatcher() {
        return matcher;
    }

    public void setMatcher(PathMatcher matcher) {
        this.matcher = matcher;
    }

    @Value("${securityconfig.userRoles}")
    private String userRoles;

    public Map<String, Collection<ConfigAttribute>> getMap() {
        return map;
    }

    public void setMap(Map<String, Collection<ConfigAttribute>> map) {
        this.map = map;
    }

    /**
     * 加载权限表中所有权限
     */
    public Map<String, Collection<ConfigAttribute>> loadResourceDefine() {
        Map<String, Collection<ConfigAttribute>> map = new HashMap<String, Collection<ConfigAttribute>>();
        if (userRoles != null && !userRoles.equals("")) {
            String[] roles = userRoles.split(";");
            for (String role : roles) {
                String[] urlAndRole = role.split("=");
                String[] userRole = urlAndRole[1].split(",");
                List<ConfigAttribute> roleList = new ArrayList();
                for (String r : userRole) {
                    ConfigAttribute v = new SecurityConfig(r);
                    roleList.add(v);
                }
                map.put(urlAndRole[0], roleList);
            }
        }
        return map;
    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String url = ((FilterInvocation) object).getRequestUrl();
        if (map == null) {
            map = loadResourceDefine();
        }
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : map.entrySet()) {
            String u = entry.getKey();
            if (matcher.match(u.trim(), url.trim())) {
                return map.get(u);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {

        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return true;
    }


    public class SecurityConfig implements ConfigAttribute {
        private String role;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public SecurityConfig(String role) {
            this.role = role;
        }

        @Override
        public String getAttribute() {

            return role;
        }
    }
}