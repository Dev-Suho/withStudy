package com.withstudy.domain;

import lombok.*;

import java.util.Date;


public class StudyBoardDTO {
    private int sb_num;
    private String member_name;
    private String sb_title;
    private String sb_tag;
    private String sb_content;
    private String sb_start_time;
    private String sb_deadLine;
    private String sb_contact;
    private Date sb_register_datetime;
    private String sb_location;
    private int sb_viewCount;
    private int sb_memberLimit;
    private int sb_joinMember;
    private String member_email;

    public int getSb_num() {
        return sb_num;
    }

    public void setSb_num(int sb_num) {
        this.sb_num = sb_num;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getSb_title() {
        return sb_title;
    }

    public void setSb_title(String sb_title) {
        this.sb_title = sb_title;
    }

    public String getSb_tag() {
        return sb_tag;
    }

    public void setSb_tag(String sb_tag) {
        this.sb_tag = sb_tag;
    }

    public String getSb_content() {
        return sb_content;
    }

    public void setSb_content(String sb_content) {
        this.sb_content = sb_content;
    }

    public String getSb_start_time() {
        return sb_start_time;
    }

    public void setSb_start_time(String sb_start_time) {
        this.sb_start_time = sb_start_time;
    }

    public String getSb_deadLine() {
        return sb_deadLine;
    }

    public void setSb_deadLine(String sb_deadLine) {
        this.sb_deadLine = sb_deadLine;
    }

    public String getSb_contact() {
        return sb_contact;
    }

    public void setSb_contact(String sb_contact) {
        this.sb_contact = sb_contact;
    }

    public Date getSb_register_datetime() {
        return sb_register_datetime;
    }

    public void setSb_register_datetime(Date sb_register_datetime) {
        this.sb_register_datetime = sb_register_datetime;
    }

    public String getSb_location() {
        return sb_location;
    }

    public void setSb_location(String sb_location) {
        this.sb_location = sb_location;
    }

    public int getSb_viewCount() {
        return sb_viewCount;
    }

    public void setSb_viewCount(int sb_viewCount) {
        this.sb_viewCount = sb_viewCount;
    }

    public int getSb_memberLimit() {
        return sb_memberLimit;
    }

    public void setSb_memberLimit(int sb_memberLimit) {
        this.sb_memberLimit = sb_memberLimit;
    }

    public int getSb_joinMember() {
        return sb_joinMember;
    }

    public void setSb_joinMember(int sb_joinMember) {
        this.sb_joinMember = sb_joinMember;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    @Override
    public String toString() {
        return "StudyBoardDTO{" +
                "sb_num=" + sb_num +
                ", member_name='" + member_name + '\'' +
                ", sb_title='" + sb_title + '\'' +
                ", sb_tag='" + sb_tag + '\'' +
                ", sb_content='" + sb_content + '\'' +
                ", sb_start_time='" + sb_start_time + '\'' +
                ", sb_deadLine='" + sb_deadLine + '\'' +
                ", sb_contact='" + sb_contact + '\'' +
                ", sb_register_datetime=" + sb_register_datetime +
                ", sb_location='" + sb_location + '\'' +
                ", sb_viewCount=" + sb_viewCount +
                ", sb_memberLimit=" + sb_memberLimit +
                ", sb_joinMember=" + sb_joinMember +
                ", member_email='" + member_email + '\'' +
                '}';
    }
}
