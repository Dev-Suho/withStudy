package com.withstudy.service;

import com.withstudy.domain.Member;
import com.withstudy.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 테스트 실행 전에 생성된다.
    // 직접 생성하지 않고 외부에서 넣어준다 (DI)
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void memberJoin() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.memberJoin(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void joinException() {
        //given
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.memberJoin(member);
        // 오른쪽 로직을 실행할때 예외를 실행되어야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.memberJoin(member2));

        // 메세지 로그가 같은지 확인할 때
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        /*
        try {
            memberService.memberJoin(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }
         */
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}