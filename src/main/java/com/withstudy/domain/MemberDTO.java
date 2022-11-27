package com.withstudy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


public class MemberDTO {
    private String member_name;
    private String member_pwd;
    private String member_email;
    private String member_role;
    private Date member_register_Datetime;

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_pwd() {
        return member_pwd;
    }

    public void setMember_pwd(String member_pwd) {
        this.member_pwd = member_pwd;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_role() {
        return member_role;
    }

    public void setMember_role(String member_role) {
        this.member_role = member_role;
    }

    public Date getMember_register_Datetime() {
        return member_register_Datetime;
    }

    public void setMember_register_Datetime(Date member_register_Datetime) {
        this.member_register_Datetime = member_register_Datetime;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "member_name='" + member_name + '\'' +
                ", member_pwd='" + member_pwd + '\'' +
                ", member_email='" + member_email + '\'' +
                ", member_role='" + member_role + '\'' +
                ", member_register_Datetime=" + member_register_Datetime +
                '}';
    }
}
