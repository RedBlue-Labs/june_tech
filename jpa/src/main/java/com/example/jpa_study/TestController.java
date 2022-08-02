package com.example.jpa_study;

import com.example.jpa_study.onetomany.Member;
import com.example.jpa_study.onetomany.Team;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class TestController {

    @PersistenceContext
    EntityManager en;

    @Transactional
    @PostMapping("/test")
    public void call() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        Team team1 = new Team("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        en.persist(member1);
        en.persist(member2);
        en.persist(team1);
    }
}
