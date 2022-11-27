package com.withstudy.repository;

import com.withstudy.domain.StudyBoardDTO;

import java.util.List;

public interface StudyBoardDAO {
    String NAMESPACE = "studyBoard.";

    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception;

    public List<StudyBoardDTO> studyBoardList() throws Exception;
}
