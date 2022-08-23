package com.example.mybatis_study.coach.repository;

import com.example.mybatis_study.coach.domain.dao.CoachAndCenter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoachRepository {
    CoachAndCenter findCoachIntoCenter(int coachId);
}
