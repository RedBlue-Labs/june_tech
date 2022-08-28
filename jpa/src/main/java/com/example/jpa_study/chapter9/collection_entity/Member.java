package com.example.jpa_study.chapter9.collection_entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address homeAddress;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "favoriteFoods", joinColumns = @JoinColumn(name = "memberId"))
    @Column(name = "foodName")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "cityHistory")),
            @AttributeOverride(name = "street", column = @Column(name = "streetHistory"))
    })
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "memberId"))
    private List<Address> addressHistory = new ArrayList<>();
}
