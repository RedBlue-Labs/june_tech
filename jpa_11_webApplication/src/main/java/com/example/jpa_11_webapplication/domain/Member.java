package com.example.jpa_11_webapplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public Long id;

    public String name;

    @Embedded
    public Address address;

    @OneToMany(mappedBy = "member")
    public List<Order> orders = new ArrayList<>();
}
