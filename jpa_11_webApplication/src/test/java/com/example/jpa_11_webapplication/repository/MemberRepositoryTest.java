package com.example.jpa_11_webapplication.repository;

import com.example.jpa_11_webapplication.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

/*
    DataJpaTest는 Entity 혹은 JPA관련된 정보들만 가져오고 Spring data jpa의 저장소를 구성한다.
    따라서 @Component인 Repository는 읽어올 수 없으므로 Import를 사용하여 주입받는다.
 */

@DataJpaTest
@Import(value = MemberRepository.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("정상적으로 회원가입이 될 경우 동일한 Entity반환")
    void test1() {
        Member member = new Member();
        member.setName("kim");

        memberRepository.save(member);

        assertThat(member).isEqualTo(memberRepository.findOne(member.getId()));
    }
}