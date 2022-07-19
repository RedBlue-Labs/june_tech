package com.example.jpa_study.entity;

import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @Transactional
    @DisplayName("연관관계 맺어진 엔티티를 삭제할 경우 [PersistenceException] 에러가 발생한다.")
    void test5() {
        test1();
        entityManager.flush();
        Team team = entityManager.find(Team.class, "team1");
        entityManager.remove(team);
        assertThatThrownBy(() -> entityManager.flush())
                .isInstanceOf(PersistenceException.class);
    }

    @Test
    @Transactional
    @DisplayName("1:N 컬렉션 조회")
    void test6() {
        test1();
        entityManager.flush();
        Team team = entityManager.find(Team.class, "team1");
        entityManager.flush();
        List<Member> members = team.getMembers();
        entityManager.flush();
        for (Member member : members) {
            System.out.println("member username = " + member.getUserName());
        }
    }

    @Test
    @DisplayName("연관관계 주인이 아닌 엔티티의 값을 변경 시 쿼리 안 생성되는지 확인")
    void test7() {
        Team team = new Team("team1", "팀1");
        entityManager.persist(team);

        Member member = new Member("member1", "회원1");
        member.setTeam(team);
        entityManager.persist(member); // 연관관계 설정

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team);
        entityManager.persist(member2); // 연관관계 설정

        team.getMembers().add(member); // 연관관계 주인이 아님으로 쿼리가 insert쿼리가 생성되지 않음.
        entityManager.flush();
    }

    @Test
    @DisplayName("연관관계 주인이 아닌 엔티티에 값 설정 시 값이 추가되지 않음.")
    void test8() {
        Member member = new Member("member1", "회원1");
        entityManager.persist(member);

        Member member2 = new Member("member2", "회원2");
        entityManager.persist(member2);

        Team team = new Team("team1", "팀1");
        team.getMembers().add(member);
        team.getMembers().add(member2);
        entityManager.persist(team);
        entityManager.flush();

        Member savedMember = entityManager.find(Member.class, "member1");
        assertThat(savedMember.getTeam()).isNull();
    }

    @Test
    @DisplayName("양방향 관계일 경우 객체들의 연관관계는 모두 맺어주기")
    void test9() {
        Team team = new Team("team1", "팀1");
        entityManager.persist(team);

        Member member = new Member("member1", "회원1");

        //양방향 연관관계 설정
        member.setTeam(team); // 연관관계 주인임으로 값 설정됨
        team.getMembers().add(member); // 연관관계 주인은 아니지만 객체임으로 연관관계 맺어주기 위함.
        entityManager.persist(member);
    }

    @Test
    @DisplayName("편의 메서드 사용하여 가독성 높이기")
    void test10() {
        Team team = new Team("team1", "팀1");
        entityManager.persist(team);

        Member member = new Member("member1", "회원1");
        member.setTeam(team);

        entityManager.persist(member);
        entityManager.flush();
    }

}