package com.withstudy.controller;

import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.service.StudyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudyBoardController {

    private final StudyBoardService studyBoardService;

    @Autowired
    public StudyBoardController(StudyBoardService studyBoardService) {
        this.studyBoardService = studyBoardService;
    }

    @PostMapping(value = "/studyBoardReg")
    public String studyBoardReg(StudyBoardDTO studyBoardDTO) throws Exception{
        studyBoardService.studyBoardReg(studyBoardDTO);

        return "studyListPage";
    }

    @GetMapping("/studyList")
    public String studyListView() throws Exception{
        List<StudyBoardDTO> studyBoardDTOS = null;
        studyBoardDTOS = studyBoardService.studyBoardList();

        System.out.println("studyList : " + studyBoardDTOS);

        return "studyListPage";
    }
}
