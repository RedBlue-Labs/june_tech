package com.example.jpa_study.chapter9.collection_entity;

import javax.persistence.Embeddable;

@Embeddable
public class ZipCode {
    private String zip;
    private String plusFour;
}
