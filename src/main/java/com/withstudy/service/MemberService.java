package com.withstudy.service;

import com.withstudy.domain.Member;
import com.withstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member saveMember(String memberID, String memberPwd, String memberName, String memberEmail) {
        Member member = new Member();
        member.setMemberID(memberID);
        member.setMemberName(memberName);
        member.setMemberEmail(memberEmail);
        member.setMemberPwd(passwordEncoder.encode(memberPwd));
        this.memberRepository.saveMember(member);

        return member;
    }

}
