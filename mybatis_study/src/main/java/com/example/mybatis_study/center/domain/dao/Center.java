package com.example.mybatis_study.center.domain.dao;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class Center {
    private String name;
    private LocalDate regDt;
    private String email;
}
