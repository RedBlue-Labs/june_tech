package com.example.mybatis_study.center.domain.dao;

import com.example.mybatis_study.coach.domain.dao.Coach;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@NoArgsConstructor
@Alias("CenterCoaches")
public class CenterCoaches {
    private Center center;
    private List<Coach> coaches;
}
