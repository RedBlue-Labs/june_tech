package com.example.mybatis_study.center.service;

import com.example.mybatis_study.center.domain.dao.Center;
import com.example.mybatis_study.center.domain.dao.MemberInfo;
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

    public MemberInfo findMemberIntoCenter(Long centerId) {
        return centerRepository.findMemberFromCenter(centerId);
    }

    public MemberInfo findMemberIntoCenter2(Long centerId) {
        return centerRepository.findMemberNestedSelect(centerId);
    }

    public List<MemberInfo> findMemberIntoCenter3() {
        return centerRepository.findMemberNestedSelectNPlusOne();
    }

    public List<MemberInfo> findMemberIntoCenter4() {
        return centerRepository.findMemberNestedSelectJoin();
    }
}
