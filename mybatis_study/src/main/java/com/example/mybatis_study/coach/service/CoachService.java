package com.example.mybatis_study.coach.service;

import com.example.mybatis_study.coach.domain.dao.Coach;
import com.example.mybatis_study.coach.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public List<Coach> findCoaches(int centerId) {
        return null;
    }
}
