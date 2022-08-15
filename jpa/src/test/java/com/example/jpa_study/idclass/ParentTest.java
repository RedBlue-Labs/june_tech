package com.example.jpa_study.idclass;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ParentTest {


    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void test1() {
        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");
        parent.setName("parent");
        em.persist(parent);
        em.flush();
        Parent findParent = em.find(Parent.class, new ParentId("id1", "id2"));
        assertThat(findParent.getName()).isEqualTo("parent");
    }

}