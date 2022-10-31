package com.withstudy.controller;

import com.withstudy.domain.Member;
import com.withstudy.domain.MemberCreateForm;
import com.withstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(MemberCreateForm memberCreateForm) {
        return "login";
    }

    @PostMapping("/join")
    public String memberJoin(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "login";
        }

        if(!memberCreateForm.getMemberPwd().equals(memberCreateForm.getMemberPwd2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "패스워드가 일치하지 않습니다.");
            return "login";
        }

        //memberService.saveMember(MemberCreateForm.)

        return "index";
    }
}
