package com.example.jpa_study.onetoone;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity(name = "member_one_to_one")
@Table(name = "member_one_to_one")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @OneToOne
    @JoinColumn(name = "lockerId")
    private Locker locker;

    public Member(String userName) {
        this.userName = userName;
    }
}
