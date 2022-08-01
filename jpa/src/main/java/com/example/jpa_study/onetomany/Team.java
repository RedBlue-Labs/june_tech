package com.example.jpa_study.onetomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "teamId") // Member의 FK
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
