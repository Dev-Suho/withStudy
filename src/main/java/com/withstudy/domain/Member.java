package com.withstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {
    // @Id : PK 선언, @GeneratedValue : 자동으로 ID 값이 생성되고 값이 증가함
    /*
    create table Member(
    memberID varchar2(50) primary key ,
    memberPwd varchar2(100),
    memberName varchar2(30),
    memberPhone varchar2(50),
    memberRegisterDate DATE default sysdate
)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberNum")
    private Long memberNum;

    @Column(nullable = false, name = "memberID", unique = true)
    private String memberID;

    @Column(nullable = false, name = "memberPwd")
    private String memberPwd;

    @Column(nullable = false, name = "memberName")
    private String memberName;

    @Column(nullable = false, name = "memberEmail", unique = true)
    private String memberEmail;

    @Column(name = "memberRole")
    private String role;

    @Column(name = "memberRegisterDate")
    private Date memberRegisterDate;

}
