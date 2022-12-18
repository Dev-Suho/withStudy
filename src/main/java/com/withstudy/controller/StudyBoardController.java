package com.withstudy.controller;

import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.service.StudyBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<StudyBoardDTO> studyBoardListOnline = studyBoardService.studyBoardListOnline();
        List<StudyBoardDTO> studyBoardListOffline = studyBoardService.studyBoardListOffline();

        ModelAndView mav = new ModelAndView("studyListPage");
        mav.addObject("onlineStudy", studyBoardListOnline);
        mav.addObject("offlineStudy", studyBoardListOffline);

        System.out.println("studyList : " + mav);

        return mav;
    }

    @GetMapping("/studyPost")
    public ModelAndView studyPostView(@RequestParam("no") int sb_num) throws Exception{
        StudyBoardDTO studyPost = studyBoardService.studyBoardPost(sb_num);
        studyBoardService.viewCount(sb_num);

        ModelAndView mav = new ModelAndView("studyPostPage");
        mav.addObject("studyPost", studyPost);

        return mav;
    }

    @GetMapping("/studyModify")
    public ModelAndView studyPostModifyView(@RequestParam("no") int sb_num) throws Exception{
        StudyBoardDTO studyPost = studyBoardService.studyBoardPost(sb_num);
        studyBoardService.viewCount(sb_num);

        ModelAndView mav = new ModelAndView("studyPostModifyPage");
        mav.addObject("studyPost", studyPost);

        return mav;
    }

    @PostMapping("/modifyComplete")
    public String modifyComplete(StudyBoardDTO studyBoardDTO) throws Exception{
        System.out.println("modify : " + studyBoardDTO.toString());
        studyBoardService.studyModify(studyBoardDTO);

        return "redirect:studyList";
    }

    @GetMapping("/studyDelete")
    public String deleteComplete(@RequestParam("no") int sb_num) throws Exception{
        studyBoardService.studyDelete(sb_num);

        return "redirect:studyList";
    }

    @PostMapping("/joinStudy")
    public String joinStudy(StudyBoardDTO studyBoardDTO) throws Exception{
        studyBoardService.joinStudy(studyBoardDTO);

        return "redirect:myPost";
    }
}
