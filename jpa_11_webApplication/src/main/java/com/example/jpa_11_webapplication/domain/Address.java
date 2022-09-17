package com.example.jpa_11_webapplication.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    public String city;
    public String street;
    public String zipCode;
}
