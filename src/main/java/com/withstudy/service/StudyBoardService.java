package com.withstudy.service;

import com.withstudy.domain.StudyBoardDTO;

import java.util.List;

public interface StudyBoardService {
    public void studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception;

    public List<StudyBoardDTO> studyBoardList() throws Exception;

    public List<StudyBoardDTO> studyBoardListOnline() throws Exception;

    public List<StudyBoardDTO> studyBoardListOffline() throws Exception;

    public StudyBoardDTO studyBoardPost(int sb_num) throws Exception;

    public void viewCount(int sb_num) throws Exception;
}
