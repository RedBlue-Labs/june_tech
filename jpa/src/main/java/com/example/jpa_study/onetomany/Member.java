package com.example.jpa_study.onetomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "teamId", insertable = false, updatable = false)
    public Team team;

    public Member(String userName) {
        this.userName = userName;
    }
}
