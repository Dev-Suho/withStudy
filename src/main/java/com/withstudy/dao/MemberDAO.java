package com.withstudy.dao;

import com.withstudy.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDAO {
    public List<Member> listMember();
}
