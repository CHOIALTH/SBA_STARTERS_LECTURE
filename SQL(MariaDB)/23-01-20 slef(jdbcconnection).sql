USE memberdb;
SELECT * FROM member;
SHOW DATABASES;

create table member
(
id varchar(10) not null PRIMARY KEY,
pw varchar(10) not NULL,
name varchar(10) ,
phone char(11)  CHECK(phone LIKE '010%'),
email varchar(30) UNIQUE,
address varchar(50),
indate DATETIME,
img VARCHAR(200)
);
DESC member;board

INSERT INTO member (id, pw, NAME, phone, email, address, indate)
VALUES
('sql', 'sql', '김1', '01012345678', 'a@sql.com', '서울시 용산',NOW()),
('sql1', 'sql', '김2', '01011111111', 'b@sql.com', '제주시 용산',NOW()),
('sql2', 'sql', '김3', '01022222222', 'c@sql.com', '대구시 용산',NOW()),
('sql3', 'sql', '김4', '01012345679', 'd@sql.com', '서울시 마포',NOW()),
('sql4', 'sql', '김5', '01012345676', 'e@sql.com', '광주시 1비',NOW()),
('sql5', 'sql', '김6', '01012345658', 'f@sql.com', '서울시 용산',NOW()),
('sql6', 'sql', '김7', '01012345677', 'g@sql.com', '서울시 용산',NOW()
);
SELECT * FROM member;


CREATE TABLE board
(seq INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
title VARCHAR(100),
contents TEXT,
writer VARCHAR(10),
viewcount INT(10) DEFAULT 0,
writingtime DATETIME DEFAULT NOW());

ALTER TABLE board 
ADD CONSTRAINT FOREIGN KEY(writer) REFERENCES member(id) 
ON DELETE CASCADE
ON UPDATE CASCADE;

DESC board;

INSERT INTO board(title, contents, writer) VALUES
('게시판개설','축하합니다','sql1'),
('두번째','나두요','sql2'),
('무엇이든지 질문하세요','스프링으로 만드나요?','sql3'),
('스프링문의','스프링답변','sql4'),
('mybatis 문의 ','mybatis 답변','sql5'),
('스프링이랑mybatis','연결합니다','sql6');

SELECT * FROM board;