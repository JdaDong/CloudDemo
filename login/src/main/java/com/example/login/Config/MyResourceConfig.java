package com.example.login.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@EnableResourceServer
@Configuration
public class MyResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/logout")
                .and()
                .authorizeRequests().antMatchers("/logout").authenticated()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);



        OAuth2AuthenticationProcessingFilter oAuth2AuthenticationProcessingFilter = new OAuth2AuthenticationProcessingFilter();
        oAuth2AuthenticationProcessingFilter.setAuthenticationEntryPoint(entryPoint);
        oAuth2AuthenticationProcessingFilter.setAuthenticationManager(authenticationManager);

        http.addFilterBefore(oAuth2AuthenticationProcessingFilter, AbstractAuthenticationProcessingFilter.class);

        
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // resources.resourceId()
    }


}
