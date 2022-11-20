package com.withstudy.controller;

import com.withstudy.domain.MemberDTO;
import com.withstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

        if (member != null){
            session.setAttribute("member", member);
            System.out.println("로그인 성공");

            return "redirect:withStudy";
        } else {
            System.out.println("로그인 실패");
            return "redirect:login";
        }
    }
}
