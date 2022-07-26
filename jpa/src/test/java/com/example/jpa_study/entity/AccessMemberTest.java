package com.example.jpa_study.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccessMemberTest {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Access 애노테이션 테스트")
    void test1() {
        AccessMember member = new AccessMember();
        member.setId(1L);
        member.setFirstName("lee");
        member.setLastName("hoo");

        em.persist(member);
        AccessMember member1 = em.find(AccessMember.class, member.getId());
        assertThat(member.getFullName()).isNotNull();
    }
}