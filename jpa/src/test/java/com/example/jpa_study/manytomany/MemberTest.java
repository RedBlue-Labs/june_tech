package com.example.jpa_study.manytomany;

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
        Product product = new Product();
        product.setName("상품");
        em.persist(product);

        Member member = new Member();
        member.setUserName("user name");
        member.getProducts().add(product);
        em.persist(member);
    }
}