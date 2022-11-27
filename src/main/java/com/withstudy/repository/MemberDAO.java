package com.withstudy.repository;

import com.withstudy.domain.MemberDTO;
import org.springframework.stereotype.Repository;

public interface MemberDAO {
    String NAMESPACE = "com.withstudy.mapper.MemberMapper.";

    // 회원가입
    public void memberSignUp(MemberDTO memberDTO) throws Exception;

    public MemberDTO login(MemberDTO memberDTO) throws Exception;
}
