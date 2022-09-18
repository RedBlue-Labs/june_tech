package com.example.jpa_11_webapplication.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("B")
public class Book extends Item {
    private String author;
    private String isbn;

    public Book(String author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }
}
