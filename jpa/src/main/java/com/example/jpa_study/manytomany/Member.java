package com.example.jpa_study.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "member_many_to_many")
@Entity(name = "member_many_to_many")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    private String userName;

    @ManyToMany
    @JoinTable(name = "member_product",
            joinColumns = @JoinColumn(name = "memberId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> products = new ArrayList<>();

}
