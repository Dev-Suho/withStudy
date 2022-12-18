package com.withstudy.controller;

import com.withstudy.domain.MemberDTO;
import com.withstudy.domain.StudyBoardDTO;
import com.withstudy.service.MemberService;
import com.withstudy.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final StudyBoardService studyBoardService;

    @Autowired
    public MemberController(MemberService memberService, StudyBoardService studyBoardService) {
        this.memberService = memberService;
        this.studyBoardService = studyBoardService;
    }

    @PostMapping(value = "/memberJoin")
    public String signUp(MemberDTO memberDTO) throws Exception{
        memberService.memberSignUp(memberDTO);

        return "signUpComplete";
    }

    @PostMapping(value = "/memberLogin")
    public String login(MemberDTO memberDTO, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3600);
        System.out.println("세션 아이디 : " + session.getId());
        System.out.println("세션 유효시간 : " + session.getMaxInactiveInterval());

        System.out.println("memberDTO : " + memberDTO);
        MemberDTO member = memberService.login(memberDTO);

        System.out.println("member : " + member);

        if (member == null){
            System.out.println("로그인 실패");
            return "redirect:login";
        } else {
            session.setAttribute("member", member);
            System.out.println("로그인 성공");
            return "redirect:withStudy";
        }
    }

    @GetMapping(value = "/myPage")
    public String myPageView() throws Exception {
        return "myPage";
    }

    @GetMapping(value = "/myPost")
    public ModelAndView myPostPageView(HttpSession session, HttpServletRequest request) throws Exception {
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
        String member_email = memberDTO.getMember_email();

        System.out.println("email" + member_email);

        List<StudyBoardDTO> joinStudy = studyBoardService.viewJoinStudy(member_email);
        List<StudyBoardDTO> createStudy = studyBoardService.viewCreateStudy(member_email);

        ModelAndView mav = new ModelAndView("myPostPage");

        mav.addObject("joinStudy", joinStudy);
        mav.addObject("createStudy" , createStudy);

        System.out.println("myPost : " + mav);
        return mav;
    }

    @GetMapping(value = "/myModify")
    public String myModifyPage() throws Exception {
        return "memberModify";
    }

    @PostMapping(value = "/modify")
    public String modify(MemberDTO memberDTO, HttpSession session, HttpServletRequest request) throws Exception {
        memberService.memberModify(memberDTO);

        // 세션 초기화
        session.invalidate();

        // 세션 재할당
        session = request.getSession();
        session.setMaxInactiveInterval(3600);
        System.out.println("세션 아이디 : " + session.getId());
        System.out.println("세션 유효시간 : " + session.getMaxInactiveInterval());
        System.out.println("memberDTO : " + memberDTO);
        MemberDTO member = memberService.login(memberDTO);
        session.setAttribute("member", member);

        return "myPage";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();

        return "redirect:withStudy";
    }
}
