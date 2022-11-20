package com.withstudy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
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
}
