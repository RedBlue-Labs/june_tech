package com.example.mybatis_study.coach.domain.dao;

import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@NoArgsConstructor
@Alias("Coach")
public class Coach {
    private Long id;
    private String name;
    private LocalDateTime regDt;
    private String email;
}
