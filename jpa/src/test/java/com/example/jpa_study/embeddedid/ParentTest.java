package com.example.jpa_study.embeddedid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class ParentTest {

    @PersistenceContext
    private EntityManager em;


    @Test
    void test1() {
        ParentId parentId = new ParentId("id1", "id2");
        ParentId parentId2 = new ParentId("id1", "id2");

        Parent parent = new Parent();
        parent.setName("test");
        parent.setId(parentId);

        em.persist(parent);

        Parent findParent = em.find(Parent.class, parentId);
        assertThat(findParent.getName()).isEqualTo("test");
        assertThat(findParent.getId()).isEqualTo(parentId2);
    }
}