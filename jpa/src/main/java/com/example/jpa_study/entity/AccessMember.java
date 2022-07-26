package com.example.jpa_study.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class AccessMember {

    @Id
    private Long id;

    @Transient
    private String firstName;

    @Transient
    private String lastName;

    private String fullName;

    @Access(AccessType.PROPERTY)
    public String getFullName() {
        return firstName + lastName;
    }
}
