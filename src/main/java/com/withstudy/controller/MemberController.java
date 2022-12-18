package com.withstudy.controller;

import com.withstudy.domain.MemberDTO;
import com.withstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
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
    public String myPostPageView() throws Exception {
        return "myPostPage";
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
