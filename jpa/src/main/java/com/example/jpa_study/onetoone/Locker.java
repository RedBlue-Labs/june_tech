package com.example.jpa_study.onetoone;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "locker_one_to_one")
@Entity(name = "locker_one_to_one")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Locker(String name) {
        this.name = name;
    }
}
