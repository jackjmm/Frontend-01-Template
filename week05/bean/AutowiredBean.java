package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredBean {

    private ComponentCreateBean componentCreateBean;

    @Autowired
    public AutowiredBean(ComponentCreateBean componentCreateBean) {
        this.componentCreateBean = componentCreateBean;
    }
}
