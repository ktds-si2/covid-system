package com.ktds.covidsystem.repository;

import com.ktds.covidsystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

// Author : JHW
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email); // 이메일로 유저찾기
    boolean existsByEmail(String email);        // 이메일 중복체크용
}
