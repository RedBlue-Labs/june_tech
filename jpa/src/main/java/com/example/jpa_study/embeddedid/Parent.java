package com.example.jpa_study.embeddedid;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Parent {

    @EmbeddedId
    private ParentId id;

    private String name;
}
