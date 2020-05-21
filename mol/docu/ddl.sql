create table member(
id 	varchar2(20) primary key,--아디
pwd varchar2(60), --패스워드
name varchar2(20), --이름
gender char(1),  --성별
path char(12), --가입경로
introduction varchar2(1000), --자기소개
regdt date --가입일자 
)

drop table board

create table board(
seq number(20),
id varchar2(20) ,
title varchar2(20), 
recommend varchar2(100),
reason varchar2(1000),  
regdt date , 
CONSTRAINT boared_PK PRIMARY KEY (seq),
CONSTRAINT boared_FK FOREIGN KEY (id) REFERENCES member(id)
ON DELETE CASCADE
)

CREATE SEQUENCE seq_mol;

update board set love = love+1 where seq = 21



drop table board

create table comments(
cseq number(20) ,
bseq number(20),
id varchar2(20) ,
comments varchar2(100),
regdt date ,
CONSTRAINT comments_PK PRIMARY KEY (cseq),
CONSTRAINT comments_FK FOREIGN KEY (bseq) REFERENCES board(seq)
ON DELETE CASCADE
)

ALTER TABLE board ADD (
    CONSTRAINT boared_PK
    PRIMARY KEY (seq)
     REFERENCES comments (bseq)
 ON DELETE CASCADE
);

