package com.example.mybatis_study.center.dto;

import com.example.mybatis_study.center.domain.dao.Center;
import lombok.Value;

import java.util.List;

@Value
public class CenterAllResponse {
    List<Center> centers;

    public CenterAllResponse(List<Center> centers) {
        this.centers = centers;
    }

    public static CenterAllResponse of(List<Center> centers) {
        return new CenterAllResponse(centers);
    }
}
