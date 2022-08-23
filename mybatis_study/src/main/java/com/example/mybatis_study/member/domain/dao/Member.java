package com.example.mybatis_study.member.domain.dao;

import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@NoArgsConstructor
@Alias("Member")
public class Member {
    private Long id;
    private String name;
    private LocalDateTime regDt;
    private String email;
    private Long centerId;
}
