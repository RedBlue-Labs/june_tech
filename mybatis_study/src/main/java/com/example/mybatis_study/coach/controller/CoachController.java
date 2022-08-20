package com.example.mybatis_study.coach.controller;

import com.example.mybatis_study.center.dto.CoachResponse;
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

    @GetMapping("/centers/{centerId}/coches")
    public ResponseEntity<CoachResponse> findCoachFromCenter(@PathVariable int centerId) {
        coachService.findCoaches(centerId);
        return ResponseEntity.ok().build();
    }
}
