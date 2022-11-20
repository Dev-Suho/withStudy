package com.withstudy.repository;

import com.withstudy.domain.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
    private final SqlSession sqlSession;

    @Autowired
    public MemberDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void memberSignUp(MemberDTO memberDTO) throws Exception {
        sqlSession.insert(NAMESPACE + "signUp", memberDTO);
    }

    @Override
    public MemberDTO login(MemberDTO memberDTO) {

        /*
        MemberDTO member = null;

        System.out.println("DAO : " + memberDTO);
        try {
            member = sqlSession.selectOne(NAMESPACE + "loginCheck", memberDTO);
            System.out.println(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return member;

         */
        MemberDTO memberDTO1;
        memberDTO1 =  sqlSession.selectOne(NAMESPACE + "loginCheck", memberDTO);
        System.out.println("dao"+memberDTO1);
        return sqlSession.selectOne(NAMESPACE + "loginCheck", memberDTO);
    }
}
