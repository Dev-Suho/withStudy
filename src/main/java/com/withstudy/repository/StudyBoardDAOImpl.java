package com.withstudy.repository;

import com.withstudy.domain.StudyBoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudyBoardDAOImpl implements StudyBoardDAO{
    private final SqlSession sqlSession;

    @Autowired
    public StudyBoardDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception {
        System.out.println("DAO Board : " + studyBoardDTO.toString());

        sqlSession.insert(NAMESPACE + "studyBoardReg",studyBoardDTO);
    }

    @Override
    public List<StudyBoardDTO> studyBoardList() throws Exception {
        List<StudyBoardDTO> studyBoardDTOS = sqlSession.selectList(NAMESPACE + "studyBoardList");
        System.out.println("LIST DAO : " + studyBoardDTOS);

        return sqlSession.selectList(NAMESPACE + "studyBoardList");
    }
}
