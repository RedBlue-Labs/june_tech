package com.example.jpa_11_webapplication.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    public String director;
    public String actor;
}
