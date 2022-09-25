package com.example.jpa_study.chapter12.service;

import com.example.jpa_study.chapter12.entity.Member;
import com.example.jpa_study.chapter12.entity.Order;
import com.example.jpa_study.chapter12.repository.OrderRepository;
import com.example.jpa_study.chapter12.repository.OrderRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderRepository2 orderRepository2;
    private final MemberService memberService;

    public List<Order> findTotalOrder() {
        return orderRepository.findAll();
    }

    public List<Order> findTotalOrder2() {
        return orderRepository2.findAll();
    }

    @Transactional
    public Order findOneOrder(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException());
        order.getMember().getUserName();
        return order;
    }

    public Order saveOrder(long memberId) {
        Member member = memberService.findOneMember(memberId);
        Order order = new Order();
        order.setMember(member);

        return orderRepository.save(order);
    }
}
