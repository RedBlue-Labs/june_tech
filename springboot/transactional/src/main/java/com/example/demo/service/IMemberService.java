package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

public interface IMemberService {
    @Transactional(readOnly = true)
    void add(String name, int age);
}
