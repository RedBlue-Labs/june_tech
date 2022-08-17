package com.example.jpa_study.one_to_one;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//자식
@Setter
@Getter
@Entity
public class BoardDetail {
    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String content;
}
