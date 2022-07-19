package com.example.jpa_study.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "MEMBER_SUB", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})
})
//@org.hibernate.annotations.DynamicUpdate // 실제 변경된 필드들만 update 치기위한 애노테이션
@Entity(name = "MEMBER_SUB")
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10) // nullable은 DDL auto를 통해 생성된 DDL에 not null 설정
    private String userName;

    private int age;

    @Enumerated(EnumType.STRING) // Enum타입은 항상 String으로 처리하자 그래야 나중에 변경에도 용이하다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // 별도의 길이 제한이 없다. DB의 타입으로는 varchar가 아닌 CLOB, BLOB타입으로 저장해야 한다.
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String id, String name) {
        this.id = id;
        this.userName = name;
    }

    public void setTeam(Team team) {
        if (this.team != null) {
            team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }
}
