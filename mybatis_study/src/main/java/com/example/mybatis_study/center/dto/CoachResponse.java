package com.example.mybatis_study.center.dto;

import com.example.mybatis_study.center.domain.dao.Center;
import com.example.mybatis_study.coach.domain.dao.CoachAndCenter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoachResponse {
    private Long id;
    private String name;
    private LocalDateTime regDt;
    private String email;
    private Center center;
    public static CoachResponse of(CoachAndCenter coachInfo) {

        return CoachResponse.builder()
                .id(coachInfo.getId())
                .name(coachInfo.getName())
                .regDt(coachInfo.getRegDt())
                .email(coachInfo.getEmail())
                .center(coachInfo.getCenter())
                .build();
    }
}
