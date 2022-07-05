package com.example.jpa_study.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MergeTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    @DisplayName("준영속 Merge 메서드 학습 테스트")
    void test1() {
        Member member = createMember("memberA", "회원1");
        member.setUserName("홍순이");
        mergeMember(member);
    }

    private void mergeMember(Member member) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Member mergeMember = em.merge(member);
        tx.commit();

        // 준영속 상태
        System.out.println("Member : " + member.getUserName());
        // 영속상태
        System.out.println("mergeMember = "+mergeMember.getUserName());
        System.out.println("em contains member = "+em.contains(member));
        System.out.println("em contains mergeMember = "+em.contains(mergeMember));
        em.close();
    }

    private Member createMember(String id, String username) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(id);
        member.setUserName(username);

        em.persist(member);
        tx.commit();

        em.close(); // 준영속상태가 된다.
        return member;
    }

}
