package com.example.jpa_11_webapplication.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "A")
public class Album extends Item {
    public String artist;
    public String etc;
}
