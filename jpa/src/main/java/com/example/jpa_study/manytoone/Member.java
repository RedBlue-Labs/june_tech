package com.example.jpa_study.manytoone;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "member_many_to_one")
@Table(name = "member_many_to_one")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String userName) {
        this.userName = userName;
    }

    public void setTeam(Team team) {
        this.team = team;

        //무한루프에 빠지지 않도록 처리
        if (!team.getMembers().contains(this)) {
            team.getMembers().add(this);
        }
    }

}
