package com.example.jpa_study.chapter12.repository;


import com.example.jpa_study.chapter12.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
