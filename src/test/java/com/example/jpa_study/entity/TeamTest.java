package com.example.jpa_study.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TeamTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    @DisplayName("회원과 팀을 저장한다.")
    void test1() {
        Team team = new Team("team1", "팀1");
        entityManager.persist(team);

        Member member = new Member("member1", "회원1");
        member.setTeam(team);
        entityManager.persist(member); // 연관관계 설정

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team);
        entityManager.persist(member2); // 연관관계 설정

        assertThat(member.getTeam()).isNotNull();
    }

    @Test
    @Transactional
    @DisplayName("JPQL을 사용하여 팀을 조회한다.")
    void test2() {
        test1();
        String jpql = "select m from MEMBER_SUB m join m.team t where t.name=:teamName";

        List<Member> resultList = entityManager.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for (Member member : resultList) {
            System.out.println("member.username = " + member.getUserName());
        }
        entityManager.flush();
    }

    @Test
    @Transactional
    @DisplayName("팀을 변경한다.")
    void test3() {
        test1();
        Team team = new Team("team2", "팀2");
        entityManager.persist(team);

        Member member = entityManager.find(Member.class, "member1");
        member.setTeam(team);
        entityManager.flush();
    }

    @Test
    @DisplayName("팀을 삭제한다.")
    void test4() {
        test1();
        Member member = entityManager.find(Member.class, "member1");
        member.setTeam(null);
        entityManager.flush();
    }
}