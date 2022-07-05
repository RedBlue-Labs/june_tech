package com.example.jpa_study.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "member")
//@org.hibernate.annotations.DynamicUpdate // 실제 변경된 필드들만 update 치기위한 애노테이션
@Entity
public class Member {
    @Id
    private String id;

    @Column(name = "name")
    private String userName;

    @Column(name = "age")
    private int age;
}
