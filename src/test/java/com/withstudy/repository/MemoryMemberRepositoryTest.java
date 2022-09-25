package com.withstudy.repository;

import com.withstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

// Test 클래스를 먼저 만들면서 검증하는 것을 테스트 주도 개발(TDD)라고 한다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // @AfterEach 메서드가 끝날때마다 실행되는 callback 메서드
    // Test 클래스들은 순서에 상관없이 실행되기 때문에 테스트 클래스 전체를 테스트할때는 메소드가 끝날때마다 저장소를 비워야한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void saveMember() {
        Member member = new Member();
        member.setName("spring");

        repository.saveMember(member);

        Member result = repository.findById(member.getId()).get();
        // alt + enter로 Assertions를 static으로 import해서 사용
        // 기본은 Assertions.assertThat(member).isEqualTo(result)
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring1");
        repository.saveMember(member);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.saveMember(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("spring1");
        repository.saveMember(member);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.saveMember(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
