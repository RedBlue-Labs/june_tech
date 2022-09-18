package com.example.jpa_11_webapplication.repository;

import com.example.jpa_11_webapplication.domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
    준영속 상태를 수정할 경우
    1. 변경 감지 기능 사용
        - 변경감지를 사용하려면 영속성 컨텍스트에서 Entity식별자를 가지고 조회한 다음 조회한 Entity를 가지고 일부 필드를 수정하는 방법
    2. 병합 사용
        - merge를 사용하면 Entity식별자를 이용해서 값을 변경하는데 이때 주의해야할 점이 모든 필드를 다 수정한다.
 */
@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item); // 준영속상태의 엔티티를 수정할때 사용한다.
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
