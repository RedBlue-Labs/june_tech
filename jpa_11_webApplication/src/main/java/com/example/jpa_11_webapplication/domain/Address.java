package com.example.jpa_11_webapplication.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@NoArgsConstructor
@Embeddable
public class Address {
    public String city;
    public String street;
    public String zipCode;

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
}
