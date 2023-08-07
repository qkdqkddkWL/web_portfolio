create table member(
    name varchar2(30) not null,
    id varchar2(30) primary key, 
    nickname varchar2(30) not null,
    pwd varchar2(30) not null,
    gender varchar2(10),
    email1 varchar2(20),
    email2 varchar2(20),
    tel1 varchar2(10),
    tel2 varchar2(10),
    tel3 varchar2(10),
    addr varchar2(100),
    regdate date
);


insert into member values ('홍길동', 'hong', '홍홍홍', '1234', '남자', 'hong', 'naver.com', '010', '1234', '5678', '경기도 수원시', sysdate);
insert into member values ('김동희', 'dong', 'dfg25', '1234', '남자', 'dong', 'gmail.com', '010', '1234', '5678', '경기도 수원시', sysdate);
insert into member values ('이일규', 'kyu', 'fhg44', '1234', '남자', 'kyu', 'naver.com', '010', '1234', '5678', '경기도 수원시', sysdate);

commit;