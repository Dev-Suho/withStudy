package com.withstudy.repository;

import com.withstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member saveMember(Member member);
    // Optional<>은 응답받은 데이터가 null일 경우에 반환하는 패키지이다.
    Optional<Member> findById(String memberID);

    List<Member> findAll();

}
