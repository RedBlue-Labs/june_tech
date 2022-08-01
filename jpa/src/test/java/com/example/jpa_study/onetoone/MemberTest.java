package com.example.jpa_study.onetoone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("1:1 연관관계 테스트")
    void test1() {
        Member member1 = new Member("member1");
        Locker lock1 = new Locker("lock1");

        member1.setLocker(lock1);

        em.persist(lock1);
        em.persist(member1);
    }
}