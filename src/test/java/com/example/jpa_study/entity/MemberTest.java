package com.example.jpa_study.entity;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
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
//@Transactional
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

    @Test
    @DisplayName("쓰기 지연 학습 테스트")
    void test3() {
        Member member1 = new Member();
        member1.setId("member1");
        member1.setUserName("홍길동");

        Member member2 = new Member();
        member2.setId("member2");
        member2.setUserName("홍길순");

        tx.begin();                 // 트랜잭션 시작

        em.persist(member1);        // 1차 캐시에 저장, 아직 DB 저장 X (쓰기 지연 발생)
        em.persist(member2);        // 1차 캐시에 저장, 아직 DB 저장 X (쓰기 지연 발생)

        tx.commit();                // 쓰기 지연 저장소의 모든 쿼리를 DB에 전달하는 Flush 발생
    }

    @Test
    @DisplayName("변경 감지 학습 테스트")
    void test4() {
        Member member1 = new Member();
        member1.setId("member3");
        member1.setUserName("홍길동");
        member1.setAge(10);
        em.persist(member1);

        tx.begin();

        Member member = em.find(Member.class, "member1");
        member.setUserName("홍순이");
//        member.setAge(15);
        tx.commit();
    }

    @Test
    @DisplayName("remove호출 시 영속성 컨텍스트에 제거되는 지 확인")
    void test5() {
        Member member1 = new Member();
        member1.setId("member1");
        member1.setUserName("홍길동");
        em.persist(member1);

        Member member = em.find(Member.class, "member1");
        em.remove(member);      // remove호출되는 순간 영속성 컨텍스트에는 제거된다. (아직 트랜잭션이 종료되지 않았지만 영속성 컨텍스트에서는 제거됨)

        Member removedMember = em.find(Member.class, "member1"); // 제거된 Entity 조회
        assertThat(removedMember).isNull();
    }

    @Test
    @DisplayName("준영속 시 영속성 컨텍스트에 관리되어있지 않는지 검증")
    void test6() {
        Member member1 = new Member();
        member1.setId("member4");
        member1.setUserName("홍길동");

        tx.begin();
        em.persist(member1);
        em.detach(member1);
        tx.commit();
        assertThat(em.contains(member1)).isFalse();
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