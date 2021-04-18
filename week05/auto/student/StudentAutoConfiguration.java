package com.example.demo.auto.student;

import com.example.demo.auto.xlass.KlassAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(StudentConfiguration.class)
@EnableConfigurationProperties(StudentProperties.class)
@AutoConfigureBefore({KlassAutoConfiguration.class})
public class StudentAutoConfiguration {

    @Autowired
    StudentConfiguration studentConfiguration;
    @Autowired
    StudentProperties studentProperties;

    @Bean
    public Student createStudent(){
        return new Student(studentConfiguration.name+"-"+studentProperties.getXlass());
    }
}
