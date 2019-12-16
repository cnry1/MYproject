package com.glp.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author zmm
 * @date 2019/12/5
 */

@Component
public class BaseAuth  extends WebSecurityConfigurerAdapter {
    @Override
    public void init(WebSecurity web) throws Exception {
        super.init(web);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


//        http
//                .authorizeRequests() //注册FilterSecurityInterceptor
//                .antMatchers("/index.html").permitAll()//访问index.html不要权限验证
//                .anyRequest().authenticated()//其他所有路径都需要权限校验
//
//                .and()
//                .csrf().disable()//默认开启，可以显示关闭
//             .cors()
//
//
//
//                //.defaultSuccessUrl()//如果用户没有访问受保护的页面，默认跳转到页面
//                //.failureUrl()
//                //.failureHandler(AuthenticationFailureHandler)
//                //.successHandler(AuthenticationSuccessHandler)
//                //.failureUrl("/login?error")
////                .permitAll();//允许所有用户都有权限访问loginPage，loginProcessingUrl，failureForwardUrl
    }
}
