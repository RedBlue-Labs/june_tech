package com.example.jpa_11_webapplication.service;

import com.example.jpa_11_webapplication.domain.Member;
import com.example.jpa_11_webapplication.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.mockito.BDDMockito.given;

/*
    SpringExtension.class를 사용하는 이유
        - 스프링 컨테이너에서 실행되게 함으로써 스프링 프레임워크가 제공하는 @Autowired등을 사용할 수 있다.

    @Transactional는 서비스레이어에서 사용할 경우에는 에러발생 시 롤백이 되지만 테스트코드에서는 테스트가 끝나면 무조건 롤백이된다.
    MockitoExtension를 사용하여 서비스레이어는 모킹테스트를 할 수 있다.
 */
@Transactional
@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입")
    void test1 () {
        Member member = new Member();
        member.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member);

        given(memberRepository.findByName("kim")).willReturn(List.of(member));

        Assertions.assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);
    }
}