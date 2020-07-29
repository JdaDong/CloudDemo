package com.example.login.Config;

import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Configuration
public class MyWebConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(MyWebConfig.class.getName());

    @Autowired
    private DataSource dataSource;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("auth");
//        auth.inMemoryAuthentication()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("admin");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("").authoritiesByUsernameQuery("").passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.addFilter()

        //authorizeRequest 验证不同url的授权问题
        http.authorizeRequests()
                .antMatchers("/login/**").hasAnyRole("admin")
                .anyRequest().permitAll()
                .and()
                //Spring Security支持两种认证方式：formLogin()和httpBasic()。
                .formLogin()
               // .loginPage("/login/loginPage").loginProcessingUrl("/login")
        .successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf8");
                PrintWriter writer = httpServletResponse.getWriter();
                HashMap<String, String> stringStringHashMap = new HashMap<>();
                stringStringHashMap.put("username", "hello");
                ObjectMapper objectWrapper = new ObjectMapper();
                writer.write(objectWrapper.writeValueAsString(stringStringHashMap));
                writer.flush();
                writer.close();
            }
        })
        .failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf8");
                PrintWriter writer = httpServletResponse.getWriter();
                HashMap<String, String> stringStringHashMap = new HashMap<>();
                stringStringHashMap.put("username", "fuckhello");
                stringStringHashMap.put("error", e.getMessage());
                ObjectMapper objectWrapper = new ObjectMapper();
                writer.write(objectWrapper.writeValueAsString(stringStringHashMap));
                writer.flush();
                writer.close();
            }
        }).usernameParameter("root").passwordParameter(passwordEncoder().encode("123456")).permitAll().and()
        .logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true)
                .logoutSuccessHandler(new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                PrintWriter writer = httpServletResponse.getWriter();
                writer.write("logout");
                writer.flush();
                writer.close();
            }
        }).and().csrf().disable()
        ;
    }
}
