package com.example.jpa_study.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SequenceBoardTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    @DisplayName("@GeneratedValue의 Sequence전략을 사용 시 PK값을 확인한다.")
    void test1() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        SequenceBoard sequenceBoard = new SequenceBoard();
        sequenceBoard.setName("test");

        em.persist(sequenceBoard);
        assertThat(sequenceBoard.getId()).isEqualTo(1);
        tx.commit();

        em.close();
    }
}