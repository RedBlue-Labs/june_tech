package com.example.jpa_study.non_identify_relationship;

import javax.persistence.*;

@Entity
public class GrandChild {
    @Id
    @GeneratedValue
    @Column(name = "grand_child_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
