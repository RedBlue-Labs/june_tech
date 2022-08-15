package com.example.jpa_study.multi_embeddedid;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/*
    식별 관계를 사용하려면 Serializable를 구현해야 한다.
    반드시 equals, hashcode를 재정의 해야 올바르게 동작한다.
    EmbeddedId를 사용할 경우 Embeddable애노테이션을 설정해야 한다.
 */
@Embeddable
public class ChildId implements Serializable {
    private String parentId;

    @Column(name = "child_id")
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildId childId = (ChildId) o;
        return Objects.equals(parentId, childId.parentId) && Objects.equals(id, childId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, id);
    }
}
