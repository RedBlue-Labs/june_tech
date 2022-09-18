package com.example.jpa_11_webapplication.repository;

import com.example.jpa_11_webapplication.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
    Repository에서 발생한 에러는 스프링이 추상화한 예외로 변환해서 Service계층에 반환한다.
    @PersistenceContext 애노테이션은 스프링 컨테이너가 관리하는 EntityManger를 주입받게 하는 애노테이션이다.
    순수 자바 프로젝트에서는 EntityManagerFactory를 직접 생성하고 관리해야 했지만 스프링에서는 이미 EntityManagerFactory를
    관리하기때문에 주입받아 사용하기만 하면된다. 이렇게 주입받아 사용해야 컨테이너가 제공하는 트랜젝션 기능등을 사용할 수 있다.

    @PersistenceUnit을 사용하여 EntityManagerFactory를 직접 주입받을 수도 있다.

 */

@Repository
public class MemberRepository {


    @PersistenceContext
    EntityManager em;

    public void save(Member member) {
         em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
