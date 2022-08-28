package com.example.jpa_study.chapter9.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "companyCity")),
            @AttributeOverride(name = "street", column = @Column(name = "companyStreet")),
            @AttributeOverride(name = "zipCode.zip", column = @Column(name = "companyZip")),
            @AttributeOverride(name = "zipCode.plusFour", column = @Column(name = "companyPlusFour"))

    })
    private Address companyAddress;

    @Embedded
    private PhoneNumber phoneNumber;
}
