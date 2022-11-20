package com.withstudy.service;

import com.withstudy.domain.MemberDTO;

public interface MemberService {

    public void memberSignUp(MemberDTO memberDTO) throws Exception;

    public MemberDTO login(MemberDTO memberDTO) throws Exception;
}
