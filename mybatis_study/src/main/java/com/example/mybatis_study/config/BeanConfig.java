package com.example.mybatis_study.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper objectMapperConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);// Getter를 쓰지 않아도 private필드에 접근 가능하도록 설정
        objectMapper.registerModule(new JavaTimeModule()); // LocalDate, LocalDateTime을
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // LocalDate, LocalDateTime을 String형식으로 직렬화하기 위한 설정
        return objectMapper;
    }
}
