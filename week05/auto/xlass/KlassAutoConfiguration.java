package com.example.demo.auto.xlass;

import com.example.demo.auto.student.Student;
import com.example.demo.auto.student.StudentConfiguration;
import com.example.demo.auto.student.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;


@Configuration
@Import(KlassConfiguration.class)
@EnableConfigurationProperties(KlassProperties.class)
public class KlassAutoConfiguration {
    @Autowired
    KlassConfiguration klassConfiguration;
    @Autowired
    KlassProperties klassProperties;
    @Autowired
    Student student;

    @Bean
    public Klass createKlass(){
        List<Student> students = new ArrayList<>();
        students.add(student);
        return new Klass(students);
    }
}
