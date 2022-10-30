select * from all_users;

create user withstudy identified by 123456;

grant connect, resource to withstudy;

회원 테이블
create table Member
(
    memberID           varchar2(50) primary key,
    memberPwd          varchar2(100),
    memberName         varchar2(30),
    memberPhone        varchar2(50),
    memberRegisterDate DATE default sysdate
)
