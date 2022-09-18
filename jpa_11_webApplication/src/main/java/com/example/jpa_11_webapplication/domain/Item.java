package com.example.jpa_11_webapplication.domain;

import com.example.jpa_11_webapplication.exception.NotEnoughStockException;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
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
    public int stockQuantity; // 재고수량

    @ManyToMany(mappedBy = "items")
    public List<Category> categories = new ArrayList<>();

    // 비즈니스 로직
    public void addStock(int quantity) {
       this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
