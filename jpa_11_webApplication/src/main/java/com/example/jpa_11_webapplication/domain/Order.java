package com.example.jpa_11_webapplication.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    public Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    public Delivery delivery;

    public LocalDate orderDate;

    @Enumerated(value = EnumType.STRING)
    public OrderStatus status;
}
