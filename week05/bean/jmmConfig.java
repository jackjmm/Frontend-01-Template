package com.example.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ContextConfiguration(locations = {"classpath:spring/spring-bean.xml"})
public class jmmConfig {

    public jmmConfig() {
    }

    @Bean(name="create")
    public ComponentCreateBean getBean(){
        return new ComponentCreateBean();
    }

}
