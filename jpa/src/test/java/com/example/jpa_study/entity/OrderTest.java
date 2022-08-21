package com.example.jpa_study.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("flush시점에 delivery, orderItem 들이 영속성 전이되어 별도의 persist호출하지 않아도 된다.")
    void test1() {
        Delivery delivery = new Delivery();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);
    }

    @Test
    @DisplayName("CascadeType REMOVE일 경우 부모가 삭제 시 자식들도 같이 삭제된다.")
    void test2() {
        Delivery delivery = new Delivery();
        delivery.setCity("test");
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);
        em.remove(order);
        em.flush();
    }
}