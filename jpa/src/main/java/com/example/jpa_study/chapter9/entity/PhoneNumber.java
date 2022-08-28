package com.example.jpa_study.chapter9.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PhoneNumber {
    private String areaCode;
    private String localNumber;
    @ManyToOne
    private PhoneServiceProvider provider;
}
