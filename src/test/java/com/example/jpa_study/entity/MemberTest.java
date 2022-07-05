package com.example.jpa_study.entity;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
class MemberTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setup() {
        em = entityManagerFactory.createEntityManager();
        tx = em.getTransaction();
    }

    @Test
    void test1() {
        try {
            tx.begin();
            login(em);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Test
    @DisplayName("1차캐시 장점으로 인한 동일성 검증 테스트")
    void test2() {
        Member member = new Member();
        member.setId("member1");
        member.setUserName("홍길동");

        em.persist(member);

        Member member1 = em.find(Member.class, "member1");
        Member member2 = em.find(Member.class, "member1");

        assertThat(member1).isSameAs(member2);
    }

    private void login(EntityManager em) {
        String id = "supermen";
        Member member = new Member();
        member.setId(id);
        member.setUserName("홍길동");

        // 등록
        em.persist(member);

        // 수정
        member.setUserName("차차차");

        //조회
        Member findMember = em.find(Member.class, id);
        System.out.println(findMember.getUserName() + ", " + findMember.getId());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("member size : " + members.size());

        //삭제
        em.remove(member);
    }
}