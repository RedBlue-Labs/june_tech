package com.example.jpa_study.chapter9.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "city")
    private String city;
    private String street;
    private String zipcode;
}
