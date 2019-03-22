package com.galen.security.config;

import com.galen.security.interceptor.MyFilterSecurityInterceptor;
import com.galen.security.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Author: Galen
 * @Date: 2019/3/22-10:12
 * @Description: spring-security 配置
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    /**
     * 注册UserDetailsService 的bean
     *
     * @return
     */
    @Bean
    UserDetailsService customUserService() {
        return new UserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        // http.authorizeRequests()每个匹配器按照它们被声明的顺序被考虑。
        http
                .authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico").permitAll()
                // ROLE_USER的权限才能访问的资源
                .antMatchers("/user/**").hasRole("USER")
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 指定登录页面,授予所有用户访问登录页面
                .loginPage("/login")
                //设置默认登录成功跳转页面,错误回到login界面
                .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("security")
                .and()
                .logout()
                .permitAll();

        /**
         * 启动登录拦截器
         */
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                //springsecurity4自动开启csrf(跨站请求伪造)与restful冲突
                .csrf().disable();
    }
}

