package com.withstudy.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
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
                '}';
    }
}
