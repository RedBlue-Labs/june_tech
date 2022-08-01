package com.example.jpa_study.onetoone2;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "locker_one_to_one2")
@Entity(name = "locker_one_to_one2")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "lockerId")
    private Member member;

    public Locker(String name) {
        this.name = name;
    }
}
