package com.example.mybatis_study.coach.domain.dao;

import com.example.mybatis_study.center.domain.dao.Center;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Alias("CoachAndCenter")
public class CoachAndCenter {
    private Long id;
    private String name;
    private LocalDateTime regDt;
    private String email;
    private Center center;
}
