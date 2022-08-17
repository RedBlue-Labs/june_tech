package com.example.jpa_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

//@EntityScan(basePackages = "com.example.jpa_study.idclass")
//@EntityScan(basePackages = "com.example.jpa_study.embeddedid")
//@EntityScan(basePackages = "com.example.jpa_study.multi_idclass")
//@EntityScan(basePackages = "com.example.jpa_study.multi_embeddedid")
//@EntityScan(basePackages = "com.example.jpa_study.non_identify_relationship")
@EntityScan(basePackages = "com.example.jpa_study.one_to_one")
@SpringBootApplication
public class JpaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApplication.class, args);
    }

}
