package com.example.jpa_study.onetoone2;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity(name = "member_one_to_one2")
@Table(name = "member_one_to_one2")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @OneToOne(mappedBy = "member")
    private Locker locker;

    public Member(String userName) {
        this.userName = userName;
    }
}
