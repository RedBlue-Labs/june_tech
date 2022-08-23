package com.example.mybatis_study.center.dto;

import com.example.mybatis_study.center.domain.dao.MemberInfo;
import com.example.mybatis_study.member.domain.dao.Member;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public class MembersResponse {
    private Long centerId;
    private String centerName;
    private LocalDate centerRegDt;
    private String centerEmail;
    private List<Member> members;
    public static MembersResponse of(MemberInfo memberInfo) {
        return MembersResponse.builder()
                .centerId(memberInfo.getCenterId())
                .centerName(memberInfo.getCenterName())
                .centerRegDt(memberInfo.getCenterRegDt())
                .centerEmail(memberInfo.getCenterEmail())
                .members(memberInfo.getMembers())
                .build();
    }
}
