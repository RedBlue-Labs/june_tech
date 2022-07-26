package com.example.jpa_study.entity;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TableBoardTest {

    @Autowired
    private EntityManager em;

    @Test
    void test1() {
        TableBoard tableBoard = new TableBoard();
        em.persist(tableBoard);
        assertThat(tableBoard.getId()).isEqualTo(1);
    }
}