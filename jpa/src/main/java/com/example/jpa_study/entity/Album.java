package com.example.jpa_study.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("A")
@Entity
public class Album extends Item {

    private String artist;
}
