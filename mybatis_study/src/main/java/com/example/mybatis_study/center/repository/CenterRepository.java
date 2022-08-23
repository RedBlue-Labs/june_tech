package com.example.mybatis_study.center.repository;

import com.example.mybatis_study.center.domain.dao.Center;
import com.example.mybatis_study.center.domain.dao.MemberInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CenterRepository {
    List<Center> findTotalCenters();

    MemberInfo findMemberFromCenter(Long centerId);

    MemberInfo findMemberNestedSelect(Long centerId);

    List<MemberInfo> findMemberNestedSelectNPlusOne();

    List<MemberInfo> findMemberNestedSelectJoin();
}
