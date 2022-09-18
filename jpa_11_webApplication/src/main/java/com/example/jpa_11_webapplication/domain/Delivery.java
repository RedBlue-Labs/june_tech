package com.example.jpa_11_webapplication.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Delivery(Address address) {
        this.address = address;
    }
}
