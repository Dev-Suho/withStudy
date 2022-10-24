package com.withstudy.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    // @Id : PK 선언, @GeneratedValue : 자동으로 ID 값이 생성되고 값이 증가함
    @Id @Column(name = "memberNum")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNum;
    private Long memberID;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private Date memberRegisterDate;

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Date getMemberRegisterDate() {
        return memberRegisterDate;
    }

    public void setMemberRegisterDate(Date memberRegisterDate) {
        this.memberRegisterDate = memberRegisterDate;
    }
}
