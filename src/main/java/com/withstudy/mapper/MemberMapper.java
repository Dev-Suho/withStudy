package com.withstudy.mapper;

import com.withstudy.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    public MemberDTO loginCheck();
}
