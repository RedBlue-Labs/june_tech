package com.example.demo.controller;

import com.example.demo.dto.MemberRequest;
import com.example.demo.service.IMemberService;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final IMemberService iMemberService;

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody MemberRequest request) {
        memberService.add(request.getName(), request.getAge());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/checked-exception")
    public ResponseEntity<Void> addCheckedException(@RequestBody MemberRequest request) throws IOException {
        memberService.addCheckedException(request.getName(), request.getAge());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/checked-exception-enable")
    public ResponseEntity<Void> addCheckedExceptionEnable(@RequestBody MemberRequest request) throws IOException {
        memberService.addCheckedExceptionEnable(request.getName(), request.getAge());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/readOnly")
    public ResponseEntity<Void> addReadOnly(@RequestBody MemberRequest request) throws IOException {
        memberService.addReadOnly(request.getName(), request.getAge());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/interface")
    public ResponseEntity<Void> addInterface(@RequestBody MemberRequest request) throws IOException {
        iMemberService.add(request.getName(), request.getAge());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public void check() {
        log.info(">>>>>>>> {} : call", this);
    }
}
