package com.withstudy.service;

import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.repository.StudyBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyBoardServiceImpl implements StudyBoardService{

    private final StudyBoardDAO studyBoardDAO;

    @Autowired
    public StudyBoardServiceImpl(StudyBoardDAO studyBoardDAO) {
        this.studyBoardDAO = studyBoardDAO;
    }

    @Override
    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception {
        System.out.println("Service Board : " + studyBoardDTO.toString());
        studyBoardDAO.studyBoardReg(studyBoardDTO);
    }

    @Override
    public List<StudyBoardDTO> studyBoardList() throws Exception {
        return studyBoardDAO.studyBoardList();
    }
}
