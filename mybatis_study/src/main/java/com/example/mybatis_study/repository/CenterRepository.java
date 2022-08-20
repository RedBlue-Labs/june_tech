package com.example.mybatis_study.repository;

import com.example.mybatis_study.domain.dao.Center;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CenterRepository {
    List<Center> findTotalCenters();
}
