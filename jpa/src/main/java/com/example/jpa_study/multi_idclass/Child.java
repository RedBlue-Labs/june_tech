package com.example.jpa_study.multi_idclass;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class Child {
    @Id
    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Parent parent;

    @Id
    @Column(name = "child_id")
    private String childId;

    private String name;
}
