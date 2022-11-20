package com.withstudy.repository;

import com.withstudy.domain.StudyBoardDTO;

public interface StudyBoardDAO {
    String NAMESPACE = "studyBoard.";

    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception;
}
