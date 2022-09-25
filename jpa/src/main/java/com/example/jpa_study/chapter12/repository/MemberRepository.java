package com.example.jpa_study.chapter12.repository;

import com.example.jpa_study.chapter12.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {


    List<Member> findAllUserName(@Param("userName") String username);

    @Query("select m from Member m where m.userName = ?1")
    Member findByUserName(String userName);

    @Query(value = "select m from Member m where m.userName = ?0", nativeQuery = true)
    Member findByUserName2(String userName);

    Page<Member> findByUserName(String userName, Pageable pageable);

    List<Member> findByUserName(String userName, Sort sort);
}
