select * from all_users;

create user withstudy identified by 123456;

grant connect, resource to withstudy;

회원 테이블
create table member(
    memberNum NUMBER primary key ,
    memberID varchar2(50),
    memberPwd varchar2(100),
    memberEmail varchar2(100),
    memberPhone varchar2(30),
    memberRegisterDate DATE default sysdate
)