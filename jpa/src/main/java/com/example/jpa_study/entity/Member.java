package com.example.jpa_study.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Getter @Setter
@AttributeOverride(name = "id", column = @Column(name = "member_id"))
@Entity
public class Member extends BaseEntity {
    private String email;
}
