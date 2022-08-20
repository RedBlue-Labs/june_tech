package com.example.mybatis_study.center.service;

import com.example.mybatis_study.center.domain.dao.Center;
import com.example.mybatis_study.center.repository.CenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CenterService {

    private final CenterRepository centerRepository;

    public List<Center> findAllCenter() {
        return centerRepository.findTotalCenters();
    }
}