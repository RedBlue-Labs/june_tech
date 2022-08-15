package com.example.jpa_study.non_identify_relationship;

import javax.persistence.*;

/*
    비 식별 관계로 구현하면 복합키가 존재하지 않으므로 구현하기 쉽다.
    또한 복합키 클래스를 따로 만들지 않아서 좋다.
 */
@Entity
public class Child {
    @Id
    @GeneratedValue
    @Column(name = "child_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
