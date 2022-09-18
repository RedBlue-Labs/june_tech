package com.example.jpa_11_webapplication.service;

import com.example.jpa_11_webapplication.domain.*;
import com.example.jpa_11_webapplication.exception.NotEnoughStockException;
import com.example.jpa_11_webapplication.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@Transactional
@SpringBootTest
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("주문이 성공한다.")
    void test1 () {
        Member member = createMember();
        Item item = createBook("시골", 10000, 10);
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
        assertThat(getOrder.getOrderItems().size()).isOne();
        assertThat(getOrder.getTotalPrice()).isEqualTo(20000);
        assertThat(item.getStockQuantity()).isEqualTo(8);
    }

    @Test
    @DisplayName("재고수량 초과 시 에러가 발생한다.")
    void test2() {
        Member member = createMember();
        Item item = createBook("시골", 10000, 10);
        int orderCount = 11;

        assertThatThrownBy(() -> orderService.order(member.getId(), item.getId(), orderCount))
                .isInstanceOf(NotEnoughStockException.class);
    }

    @Test
    @DisplayName("주문 취소가 성공한다.")
    void test3() {
        Member member = createMember();
        Item item = createBook("시골", 10000, 10);
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        orderService.cancelOrder(orderId);

        Order order = orderRepository.findOne(orderId);

        assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCEL);
        assertThat(item.getStockQuantity()).isEqualTo(10);
    }

    private Item createBook(String name, int price, int stockQuantity) {
        Book book = new Book("june", "123456");
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "경기", "123-456"));
        em.persist(member);
        return member;
    }
}