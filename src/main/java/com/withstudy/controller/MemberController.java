package com.withstudy.controller;

import com.withstudy.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;
}
