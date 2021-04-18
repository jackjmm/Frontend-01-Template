package com.example.demo.auto;

import com.example.demo.DemoApplication;
import com.example.demo.auto.student.StudentAutoConfiguration;
import com.example.demo.auto.xlass.KlassAutoConfiguration;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter({StudentAutoConfiguration.class,KlassAutoConfiguration.class})
@RequiredArgsConstructor
@EnableConfigurationProperties(DemoApplication.class)
public class StudentAndKlassAutoConfiguration {

}
