package com.example.turbinedashboard;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@SpringBootApplication
public class TurbinedashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbinedashboardApplication.class, args);
    }

    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean
    public DataSource dataSource(){
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("");

        return (DataSource)jndiObjectFactoryBean.getObject();
    }

}
