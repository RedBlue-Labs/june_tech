package com.example.jpa_study.chapter12.entity;

import lombok.Getter;

import javax.persistence.*;

@NamedQuery(
        name = "Member.findAllUserName",
        query = "select m from Member m where m.userName = :userName"
)
@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    public static Member createMember(String name) {
        Member member = new Member();
        member.userName = name;
        return member;
    }
}
