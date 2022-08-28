package com.example.jpa_study.chapter9.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("값 타입의 공유 참조시 side effect발생")
    void test1() {
        Member member1  = new Member();
        member1.setHomeAddress(new Address("oldCity", "test"));
        Address homeAddress = member1.getHomeAddress();
//        homeAddress.setCity("testCity"); // 참조형이라 원본값도 변경됨

        Member member2 = new Member();
        member2.setHomeAddress(homeAddress);

        assertThat(member1.getHomeAddress().getCity()).isEqualTo("testCity");
        assertThat(member2.getHomeAddress().getCity()).isEqualTo("testCity");
    }

    @Test
    @DisplayName("값 타입일 경우 항상 Emmutable Object로 만들어야 한다.")
    void test2() {
        Member member1  = new Member();
        member1.setHomeAddress(new Address("oldCity", "test"));

        Member member2 = new Member();
        member2.setHomeAddress(new Address("testCity", "test"));

        assertThat(member1.getHomeAddress().getCity()).isEqualTo("oldCity");
        assertThat(member2.getHomeAddress().getCity()).isEqualTo("testCity");
    }
}