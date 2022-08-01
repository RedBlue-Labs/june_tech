package com.example.jpa_study.onetoone2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void test1() {
        Member member2 = new Member("member2");
        Locker lock2 = new Locker("lock2");

        lock2.setMember(member2);

        em.persist(lock2);
        em.persist(member2);
    }
}