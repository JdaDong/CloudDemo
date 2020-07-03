package com.example.amin;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public SecurityConfig(AdminServerProperties properties){
        this.adminContextPath = properties.getContextPath();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler  handler = new SavedRequestAwareAuthenticationSuccessHandler();
        handler.setTargetUrlParameter("redirectTo");
        http.authorizeRequests()
                       .antMatchers(adminContextPath + "/assets/**").permitAll()
                        .antMatchers(adminContextPath + "/login").permitAll()
                         .antMatchers(adminContextPath + "/actuator/**").permitAll()
                        .anyRequest().authenticated()
                         .and()
                        .formLogin().loginPage(adminContextPath + "/login").successHandler(handler)
                         .and()
                         .logout().logoutUrl(adminContextPath + "/logout").and()
                        .httpBasic().and().csrf().disable();
    }
}
