package com.example.mybatis_study.coach.controller;

import com.example.mybatis_study.coach.dto.CoachResponse;
import com.example.mybatis_study.coach.domain.dao.CoachAndCenter;
import com.example.mybatis_study.coach.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class CoachController {

    private final CoachService coachService;

    @GetMapping("/coches/{coachId}")
    public ResponseEntity<CoachResponse> findCoachFromCenter(@PathVariable int coachId) {
        CoachAndCenter coachInfo = coachService.findCoachInfo(coachId);
        return ResponseEntity.ok(CoachResponse.of(coachInfo));
    }
}
