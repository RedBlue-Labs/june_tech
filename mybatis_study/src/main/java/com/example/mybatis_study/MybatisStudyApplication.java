package com.example.mybatis_study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatis_study.**.repository")
public class MybatisStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStudyApplication.class, args);
    }

}
