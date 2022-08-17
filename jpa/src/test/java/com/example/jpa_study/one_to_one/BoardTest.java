package com.example.jpa_study.one_to_one;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BoardTest {

    @PersistenceContext
    private EntityManager em;


    @Test
    void test1() {
        Board board = new Board();
        board.setTitle("제목");
        em.persist(board);

        BoardDetail boardDetail = new BoardDetail();
        boardDetail.setContent("내용");
        boardDetail.setBoard(board);
        em.persist(boardDetail);
    }
}