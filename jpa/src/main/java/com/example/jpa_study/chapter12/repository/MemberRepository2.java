package com.example.jpa_study.chapter12.repository;

import com.example.jpa_study.chapter12.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository2 {
    @PersistenceContext
    private EntityManager em;


    public List<Member> findByUserName(String username) {
        List<Member> memberList = em.createNamedQuery("Member.findByUserName", Member.class)
                .setParameter("userName", username)
                .getResultList();

        return memberList;
    }
}
