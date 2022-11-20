package com.withstudy.service;

import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.repository.StudyBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyBoardServiceImpl implements StudyBoardService{

    private final StudyBoardDAO studyBoardDAO;

    @Autowired
    public StudyBoardServiceImpl(StudyBoardDAO studyBoardDAO) {
        this.studyBoardDAO = studyBoardDAO;
    }

    @Override
    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception {
        studyBoardDAO.studyBoardReg(studyBoardDTO);
    }
}
