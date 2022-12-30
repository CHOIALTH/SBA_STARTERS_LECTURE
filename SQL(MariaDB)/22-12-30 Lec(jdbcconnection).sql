CREATE USER jdbc IDENTIFIED BY 'jdbc';
DROP USER jdbc;
CREATE DATABASE memberdb;

DROP DATABASE memberdb;
GRANT ALL privileges ON memberdb.* TO jdbc@'%';
-- memberdb.* : sql 기능 다 허용하겠다
--  memberdb.select : select만 허용하겠다 .. 
SHOW GRANTs FOR 'jdbc'@'%';
SHOW DATABASEs;

USE memberdb;
SELECT * FROM MEMBERDB;

select host,user from mysql.user; -- DB 계정 목록 보는 방법
flush PRIVILEGES; -- 권한 갱신

grant all privileges on memberdb.* to 'jdbc'@'%' identified by 'jdbc' with grant option;







