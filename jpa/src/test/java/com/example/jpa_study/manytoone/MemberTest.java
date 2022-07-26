package com.example.jpa_study.manytoone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
class MemberTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("편의메서드를 사용하여 연관관계 매핑")
    void test1() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        Team team1 = new Team("team1");
        team1.addMember(member1);
        team1.addMember(member2);

        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(team1);

        Team team = entityManager.find(Team.class, 1L);
        team.getMembers().stream()
                .forEach(System.out::println);
        Member member = entityManager.find(Member.class, 1L);
        System.out.println(member);
    }
}