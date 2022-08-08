package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements IMemberService {

    private final MemberRepository memberRepository;

    @Override
    public void add(String name, int age) {
        memberRepository.save(new Member(name, age));
    }
}
