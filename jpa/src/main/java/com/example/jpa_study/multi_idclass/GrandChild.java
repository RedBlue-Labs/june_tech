package com.example.jpa_study.multi_idclass;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
public class GrandChild {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id"),
            @JoinColumn(name = "child_id")
    })
    private Child child;

    @Id
    @Column(name = "grandchild_id")
    private String id;

    private String name;
}
