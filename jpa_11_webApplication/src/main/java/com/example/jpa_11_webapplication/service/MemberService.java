package com.example.jpa_11_webapplication.service;

import com.example.jpa_11_webapplication.domain.Member;
import com.example.jpa_11_webapplication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    Transactional 애노테이션 같은 경우 스프링에서는 unchecked Exception만 롤백대상이 된다.
    따라서 별도의 Checked Exception도 롤백 대상이 되게 하기위해선 rollbackFor = Exception.class 처럼 등록해 주어야 한다.
 */

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
