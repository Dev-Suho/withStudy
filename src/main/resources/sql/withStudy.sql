create table Member(
                       member_email varchar2(100) primary key ,
                       member_pwd varchar2(100),
                       member_name varchar2(30),
                       member_role varchar2(10) default 'General',
                       member_register_Datetime DATE default sysdate
);

create table studyBoard(
                           sb_num number primary key ,
                           member_name varchar2(30),
                           sb_title varchar2(100),
                           sb_tag varchar2(100),
                           sb_content varchar2(255),
                           sb_start_time varchar2(100),
                           sb_deadLine varchar2(100),
                           sb_contact varchar2(100),
                           sb_register_datetime DATE DEFAULT sysdate
);

create sequence sb_num_seq;