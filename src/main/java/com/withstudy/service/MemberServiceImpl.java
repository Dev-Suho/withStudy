package com.withstudy.service;

import com.withstudy.domain.MemberDTO;
import com.withstudy.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public void memberSignUp(MemberDTO memberDTO) throws Exception {
        System.out.println("Service : " + memberDTO.toString());
        memberDAO.memberSignUp(memberDTO);
    }

    @Override
    public MemberDTO login(MemberDTO memberDTO) throws Exception {
        return memberDAO.login(memberDTO);
    }
}
