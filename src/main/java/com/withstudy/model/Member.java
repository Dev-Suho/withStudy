package com.withstudy.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Member {
    private int member_num;
    private String member_name;
    private String member_pwd;
    private String member_email;
    private Date member_registerDate;
}
