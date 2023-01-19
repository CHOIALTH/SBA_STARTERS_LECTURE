SHOW DATABASES;
CREATE DATABASE memberdb;
USE memberdb;
create table member
(
id varchar(10) not null PRIMARY KEY,
pw varchar(10) not NULL,
name varchar(10) ,
phone char(11)  CHECK(phone LIKE '010%'),
email varchar(30) UNIQUE,
address varchar(50),
indate DATETIME
);
DESC member;	