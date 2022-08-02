package com.example.jpa_study.entity;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED) // 상속관계에서 join을 사용하겠다고 명시적으로 전략 설정
@DiscriminatorColumn(name = "DTYPE")    // 구분칼럼을 설정하여 해당 컬럼으로 자식 테이블을 구분할 수 있다.
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
}
