package com.example.jpa_11_webapplication.domain;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    public Long id;

    @OneToOne(mappedBy = "delivery")
    public Order order;

    @Embedded
    public Address address;

    @Enumerated(value = EnumType.STRING)
    public DeliveryStatus status;
}
