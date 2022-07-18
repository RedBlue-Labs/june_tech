package com.example.jpa_study.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
