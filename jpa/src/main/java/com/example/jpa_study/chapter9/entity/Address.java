package com.example.jpa_study.chapter9.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {
    @Column(name = "city")
    private String city;
    private String street;
    @Embedded
    private ZipCode zipCode;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
