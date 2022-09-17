package com.example.jpa_11_webapplication.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    public Long id;

    public String name;
    public int price;
    public int stockQuantity;

    @ManyToMany(mappedBy = "items")
    public List<Category> categories = new ArrayList<>();
}
