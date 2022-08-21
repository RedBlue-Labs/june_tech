package com.example.jpa_study.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {
    private LocalDate createDate;
    private LocalDate lastModifiedDate;
}
