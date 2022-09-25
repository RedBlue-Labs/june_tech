package com.example.jpa_study.chapter12.service;

import com.example.jpa_study.chapter12.entity.Member;
import com.example.jpa_study.chapter12.repository.MemberRepository;
import com.example.jpa_study.chapter12.repository.MemberRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository2 memberRepository2;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(String name) {
        memberRepository.save(Member.createMember(name));
    }

    public List<Member> findAllMember(String name) {
        List<Member> byUserName = memberRepository.findAllUserName(name);
        return byUserName;
    }

    public Page<Member> findByName(String userName ) {
        return  memberRepository.findByUserName(userName, PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "id")));
    }

    public Member findOneMember(long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Member> sortMember(String userName) {
        return memberRepository.findByUserName(userName, Sort.by(Sort.Direction.DESC, "id"));
    }
}
