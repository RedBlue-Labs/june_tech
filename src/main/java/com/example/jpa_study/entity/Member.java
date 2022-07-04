package com.example.jpa_study.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "member")
@Entity
public class Member {
    @Id
    private String id;
    @Column(name = "name")
    private String userName;
}
