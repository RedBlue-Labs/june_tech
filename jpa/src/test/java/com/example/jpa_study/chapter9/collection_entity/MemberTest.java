package com.example.jpa_study.chapter9.collection_entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberTest {

    @PersistenceContext
    private EntityManager em;


    @Test
    @DisplayName("값 타입 컬렉션 사용 시 Entity를 저장 시 컬렉션 갯수만큼 insert가 일어난다.")
    void test1() {
        Member member = new Member();

        //임베디드 값 타입
        member.setHomeAddress(new Address("통영", "해수욕장"));

        //기본값 타입 컬렉션
        member.getFavoriteFoods().add("짬뽕");
        member.getFavoriteFoods().add("짜장면");
        member.getFavoriteFoods().add("탕수육");

        //임베디드 값 타입 컬렉션
        member.getAddressHistory().add(new Address("서울", "서울해수욕장"));
        member.getAddressHistory().add(new Address("대전", "대전해수욕장"));

        em.persist(member);

        em.flush();
    }
}