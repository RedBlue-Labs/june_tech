package com.example.jpa_study.entity;

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
class BoardTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    @DisplayName("@GeneratedValue의 Identity전략을 사용하여 PK값을 확인한다.")
    void test1() {
        Board board = new Board();
        board.setName("첫번째 보드");

        entityManager.persist(board);

        assertThat(board.getId()).isEqualTo(1);
    }
}