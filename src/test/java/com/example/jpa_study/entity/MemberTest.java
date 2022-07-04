package com.example.jpa_study.entity;

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

    @Test

    void test1() {
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction tx = em.getTransaction();

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