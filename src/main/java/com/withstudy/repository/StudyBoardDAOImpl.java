package com.withstudy.repository;

import com.withstudy.domain.StudyBoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyBoardDAOImpl implements StudyBoardDAO{
    private final SqlSession sqlSession;

    @Autowired
    public StudyBoardDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception {
        sqlSession.insert(NAMESPACE + "studyBoardReg",studyBoardDTO);
    }
}
