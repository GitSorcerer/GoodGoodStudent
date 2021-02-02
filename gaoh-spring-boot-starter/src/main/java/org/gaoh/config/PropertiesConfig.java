package org.gaoh.config;

import org.gaoh.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/2/2 15:56
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties(StudentProperties.class)
public class PropertiesConfig {

    @Autowired
    private StudentProperties properties;

    @Bean
    public Student initStu() {
        return new Student(properties.getName(), properties.getAge());
    }
}
