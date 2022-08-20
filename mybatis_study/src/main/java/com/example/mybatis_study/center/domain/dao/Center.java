package com.example.mybatis_study.center.domain.dao;

import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@NoArgsConstructor
@Alias("Center")
public class Center {
    private String name;
    private LocalDate regDt;
    private String email;
}
