package com.example.jpa_study.idclass;

import javax.persistence.*;

@Entity
public class Child {

    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id1", referencedColumnName = "parent_id1"), // name과 referencedColumnName이름이 같으면 referencedColumnName의 이름은 생략 가능하다.
            @JoinColumn(name = "parent_id2", referencedColumnName = "parent_id2")
    })
    private Parent parent;
}
