package com.example.jpa_study.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "bookId")  // 부모테이블의 PK칼럼명 그대로 사용하지 않기위해 PK 칼럼명을 설정한다.
@DiscriminatorValue("B")
@Entity
public class Book extends Item {

    private String author;
    private String isbn;
}
