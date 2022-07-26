package com.example.jpa_study.manytoone;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "team_many_to_one")
@Table(name = "team_many_to_one")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addMember(Member member) {
        this.members.add(member);
        //무한루프에 빠지지 않도록 처리
        if (member.getTeam() != this) {
            member.setTeam(this);
        }
    }
}
