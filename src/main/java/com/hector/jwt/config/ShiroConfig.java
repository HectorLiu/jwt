package com.hector.jwt.config;

import com.hector.jwt.shiro.JWTFilter;
import com.hector.jwt.shiro.JWTReaml;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

//        // logged in users with the 'admin' role
//        chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
//
//        // logged in users with the 'document:read' permission
//        chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");

        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/**", "jwt");
        return chainDefinition;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getManger() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(new JWTReaml());

        return manager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager manager, ShiroFilterChainDefinition shiroFilterChainDefinition) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(manager);

        // add filter
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());


        return shiroFilterFactoryBean;

    }


}
