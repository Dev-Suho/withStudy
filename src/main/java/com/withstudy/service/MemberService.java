package com.withstudy.service;

import com.withstudy.domain.Member;
import com.withstudy.repository.MemberRepository;
import com.withstudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long memberJoin(Member member) {
        validateDuplicateMember(member);    // 중복 회원을 검증한다.
        memberRepository.saveMember(member);

        //return member.getId();
        return null;
    }

    // 중복 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getMemberName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 로그인
    /*
    public int memberLogin(Member member) {return memberRepository.saveMember(member);}

     */
    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
