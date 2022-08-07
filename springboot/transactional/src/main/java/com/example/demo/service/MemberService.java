package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void add(String name, int age) {
        memberRepository.save(new Member(name, age));
    }

    @Transactional
    public void addCheckedException(String name, int age) throws IOException {
        log.info("{}", this);
        memberRepository.save(new Member(name, age));
        throw new IOException("test");
    }

    @Transactional(rollbackFor = Exception.class)
    public void addCheckedExceptionEnable(String name, int age) throws IOException {
        log.info("{}", this);
        memberRepository.save(new Member(name, age));
        throw new IOException("test");
    }
    @Transactional(readOnly = true)
    public void addReadOnly(String name, int age) {
        List<Member> members = memberRepository.findAll();
        members.forEach(member -> log.info("{}", member));
        add(name, age);
    }
}
