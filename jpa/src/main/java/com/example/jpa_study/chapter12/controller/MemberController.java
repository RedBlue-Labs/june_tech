package com.example.jpa_study.chapter12.controller;

import com.example.jpa_study.chapter12.entity.Member;
import com.example.jpa_study.chapter12.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/create/{name}")
    public void insertMember(@PathVariable String name) {
        memberService.saveMember(name);
    }

    @GetMapping("/api/members/{name}")
    public ResponseEntity<List<Member>> getAll(@PathVariable String name) {
        return ResponseEntity.ok(memberService.findAllMember(name));
    }

    @GetMapping("/api/member/{name}")
    public ResponseEntity<Page<Member>> getMember(@PathVariable String name) {
        Page<Member> members = memberService.findByName(name);
        return ResponseEntity.ok(members);
    }
}
