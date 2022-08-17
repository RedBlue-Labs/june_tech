package com.example.jpa_study.one_to_one;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//부모
@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;
}
