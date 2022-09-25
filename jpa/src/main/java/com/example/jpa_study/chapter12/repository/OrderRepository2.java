package com.example.jpa_study.chapter12.repository;

import com.example.jpa_study.chapter12.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository2 {

    @PersistenceContext
    private EntityManager em;

    public List<Order> findAll() {
        return em.createQuery("select o from Order o join fetch o.member", Order.class)
                .getResultList();
    }
}
