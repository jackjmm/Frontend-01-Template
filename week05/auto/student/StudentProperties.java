package com.example.demo.auto.student;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "stu")
public class StudentProperties {
    private String xlass = "java2期";

    public String getXlass() {
        return xlass;
    }

    public void setXlass(String xlass) {
        this.xlass = xlass;
    }
}
