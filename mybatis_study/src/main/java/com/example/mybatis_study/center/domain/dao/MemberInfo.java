package com.example.mybatis_study.center.domain.dao;

import com.example.mybatis_study.member.domain.dao.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@Alias("MemberInfo")
public class MemberInfo {
    private Long centerId;
    private String centerName;
    private LocalDate centerRegDt;
    private String centerEmail;
    private List<Member> members;
}
