package com.example.jpa_study.multi_embeddedid;

import javax.persistence.*;

@Entity
public class Child {

    @EmbeddedId
    private ChildId id;

    @MapsId(value = "parentId") //childId 필드인 parentId로 매핑됨
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    private String name;
}
