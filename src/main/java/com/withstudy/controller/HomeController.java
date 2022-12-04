package com.withstudy.controller;


import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.service.StudyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final StudyBoardService studyBoardService;

    @Autowired
    public HomeController(StudyBoardService studyBoardService) {
        this.studyBoardService = studyBoardService;
    }

    @GetMapping(value = {"/withStudy", "/"})
    public ModelAndView viewHome() throws Exception {
        List<StudyBoardDTO> studyBoardDTOS = null;
        studyBoardDTOS = studyBoardService.studyBoardList();

        ModelAndView mav = new ModelAndView("withStudy");
        mav.addObject("boardList", studyBoardDTOS);

        return mav;
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/community")
    public String communityView() {
        return "communityPage";
    }

    @GetMapping("/signUp")
    public String singUpView() {
        return "signUpPage";
    }

    @GetMapping("/signUpComplete")
    public String signUpCompleteView() { return "signUpComplete"; }

    @GetMapping("/studyBoard")
    public String studyBoardView() {
        return "studyBoard";
    }

}
