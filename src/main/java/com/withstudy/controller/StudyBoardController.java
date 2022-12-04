package com.withstudy.controller;

import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.service.StudyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
        System.out.println("Controller Board : " + studyBoardDTO.toString());
        studyBoardService.studyBoardReg(studyBoardDTO);

        return "redirect:studyList";
    }

    @GetMapping("/studyList")
    public ModelAndView studyListView() throws Exception{
        List<StudyBoardDTO> studyBoardDTOS = null;
        studyBoardDTOS = studyBoardService.studyBoardList();

        ModelAndView mav = new ModelAndView("studyListPage");
        mav.addObject("boardList", studyBoardDTOS);

        System.out.println("studyList : " + mav);

        return mav;
    }
}
