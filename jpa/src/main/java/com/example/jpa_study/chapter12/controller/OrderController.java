package com.example.jpa_study.chapter12.controller;

import com.example.jpa_study.chapter12.entity.Order;
import com.example.jpa_study.chapter12.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/api/orders")
    public ResponseEntity<List<Order>> findAllOrder() {
        return ResponseEntity.ok(orderService.findTotalOrder());
    }

    @GetMapping("/api/orders2")
    public ResponseEntity<List<Order>> findAllOrder2() {
        return ResponseEntity.ok(orderService.findTotalOrder2());
    }

    @PostMapping("/api/member/{memberId}/order")
    public ResponseEntity<?> saveOrder(@PathVariable long memberId) {
        return ResponseEntity.ok(orderService.saveOrder(memberId));
    }

    @GetMapping("/api/order/{orderId}")
    public ResponseEntity<Order> findOrder(@PathVariable("orderId") Long id) {
        return ResponseEntity.ok(orderService.findOneOrder(id));
    }
}
