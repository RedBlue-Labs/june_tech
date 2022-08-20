package com.example.mybatis_study.center.controller;

import com.example.mybatis_study.center.domain.dao.Center;
import com.example.mybatis_study.center.dto.CenterAllResponse;
import com.example.mybatis_study.center.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/centers")
@RequiredArgsConstructor
@RestController
public class CenterController {

    private final CenterService centerService;
    @GetMapping("/all")
    public ResponseEntity<CenterAllResponse> findAllCenter() {

        List<Center> allCenter = centerService.findAllCenter();
        return new ResponseEntity<>(CenterAllResponse.of(allCenter), HttpStatus.OK);
    }
}
