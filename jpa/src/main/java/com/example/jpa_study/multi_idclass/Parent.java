package com.example.jpa_study.multi_idclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {
    @Id
    @Column(name = "parent_id")
    private String id;

    private String name;
}
