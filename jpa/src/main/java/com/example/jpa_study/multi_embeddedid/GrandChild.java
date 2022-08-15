package com.example.jpa_study.multi_embeddedid;


import javax.persistence.*;

@Entity
public class GrandChild {
    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "partner_id"),
            @JoinColumn(name = "child_id")
    })
    private Child child;

    private String name;
}
