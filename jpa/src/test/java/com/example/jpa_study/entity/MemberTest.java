package com.example.jpa_study.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void test1() {
        Member member = new Member();
        member.setEmail("test@test.com");

        em.persist(member);
        Assertions.assertThat(member.getId()).isEqualTo(1);
    }
}