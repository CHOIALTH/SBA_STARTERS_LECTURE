USE empdb;
-- empdb 클릭
SELECT * FROM employees;

DESC employees;
-- 6장 데이터 관리
-- employees 테이블 사번, 이름, 성, 급여, 입사일, 부서코드 컬럼 복사 테이블

CREATE TABLE emp_copy
(SELECT employee_id, first_name, last_name, salary, hire_date, department_id FROM employees);
-- employees 테이블 내 일부 컬럼 복사한 꼴.
-- 괄호 안에 조회문장을 작성
DESC emp_copy;
SELECT * FROM emp_copy;
ALTER TABLE emp_copy ADD CONSTRAINT PRIMARY KEY(employee_id);

-- 1 이사원 15000 2022-12-26 10 삽입
-- INSERT INTO 테이블명 (각 컬럼명 리스트) VALUES (값리스트);
INSERT INTO emp_copy (employee_id, first_name, last_name,hire_date) VALUES (4, "길동", "김홍",  "2022-12-26");

-- 여러개 insert!
INSERT INTO emp_copy VALUES
(5, "길동", "홍", 7000, "2012-11-26", NULL),
(6, "길동", "홍", null, "2012-11-26", NULL),
(7, "길동", "홍", null, "2002-09-26", 50);

INSERT IGNORE INTO emp_copy VALUES
(8, "도원", "곽", 7000, "2012", NULL);
INSERT IGNORE INTO emp_copy VALUES
(7, "길동", "홍", null, "2002-09-26", 50);
SHOW VARIABLES LIKE 'auto%';
-- autocommit on 상태 : 

INSERT INTO emp_copy
SELECT employee_id, first_name, last_name, salary, hire_date, department_id FROM employees;


-- delete 문장은 autocommit 상태 설정 변경하면 복구 기회 있는 SQL
-- where 절 사용 가능
-- truncate 문장은 autocommit 상태 설정 변경해도 무시. 복구 기회 없는 SQL
-- where 절 사용 불가능

-- update 
-- update 테이블명 set 변경 컬럼명 = 값 where 변경조건식 문법 유사

-- 1번 사원 급여 10% 인상
UPDATE emp_copy set salary = salary * 1.1 WHERE employee_id = 1;

-- 입사월 6월 사원 부서 20번 에 배정하고 급여 20% 인상 - 테이블변경

UPDATE emp_copy SET department_id = 20, salary = salary * 1.2 WHERE hire_date LIKE '_____06%';
SELECT department_id, salary, hire_date FROM emp_copy WHERE hire_date LIKE '_____06%';
-- _____06% 언더바 5개 이유 (xxxx- 형태)

CREATE TABLE product
(
p_CODE INT PRIMARY KEY,
p_NAME CHAR(30) NOT NULL,
price DECIMAL,
balance SMALLINT CHECK (balance >= 0)
);
DESC product;
SELECT * FROM product;

SELECT * FROM information_schema.table_constraints
WHERE TABLE_NAME = 'product';
-- not null 제외 제약조건 정보를 보여줌

USE information_schema;
SELECT * FROM table_constraints
WHERE TABLE_NAME = 'product';
-- 이 3줄의 명령문도 not null 제외 제약조건 정보를 보여줌

USE empdb;
INSERT INTO product VALUES(100, '냉장고', 1000000, 10);
-- INSERT INTO product VALUES(101, '키보드', 1000000, -10); -- 오류발생
INSERT INTO product VALUES(102, '마우스', 1000000, 5); 
INSERT INTO product VALUES(103, '컴퓨터', 1000000, 0);
INSERT INTO product VALUES(100, '냉장고', 1000000, 10);
SELECT * FROM product;

ALTER TABLE product MODIFY p_code INT NOT NULL AUTO_INCREMENT; 
-- 
DESC product;
SELECT * FROM product;

INSERT INTO product (p_name, price, balance) VALUES ("아이폰", 1900000, 3);


-- auto increment 설정시 ㅐㅐ
-- int타입이면서 primary key인 경우 보통 auto_increment로 만듬
CREATE TABLE a(
id INT AUTO_INCREMENT 
);

-- 회원정보 저장할 테이블
-- user_id char(10) 중복x null 허용x / user_pw 문자5자리(한글은 3byte차지 하므로.. 영문자나 숫자 넣도록) null 허용x
-- user_name 문자 30자리 / user_email 문자 30자리 중복x / user_phone 문자 12자리 중복x / address 문자 100자리

CREATE TABLE user_info(
user_id CHAR(10) PRIMARY KEY,
user_pw CHAR(5)  NOT NULL,
user_name CHAR(30),
user_email CHAR(30) UNIQUE,
user_phone CHAR(12) CHECK(user_phone LIKE '010-%'),
address CHAR(100)
);
DESC user_info;

DROP TABLE user_info;

SELECT * FROM table_constraints WHERE TABLE_NAME = 'user_info';
SELECT * FROM information_schema.CHECK_CONSTRAINTS;
SELECT TABLE_NAME, CONSTRAINT_NAME, CHECK_CLAUSE FROM information_schema.CHECK_CONSTRAINTS;

USE empdb;
SELECT * FROM user_info;
INSERT INTO user_info VALUES("maria", "db", "홍길동", "hong@a.com", "010-23456789", "서울시 용산구");
INSERT INTO user_info VALUES("maria2", "db", "홍길동", "hong2@a.com", "010-23456789", "서울시 용산구"); -- check 

CREATE TABLE board(
seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
title CHAR(100) NOT NULL,
contents TEXT, -- 65536byte
viewcount INT DEFAULT 0,
writer CHAR(10), 
CONSTRAINT fk_board_writer FOREIGN KEY(writer) REFERENCES user_info(user_id)

-- 1. user_info(부모테이블)의 user_id 컬럼에 pk 설정돼있어야한다 
-- 2. writer 컬럼은 user_info의 user_id와 타입 및 길이 일치해야한다.

);
DESC board;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME = "board";
 
 CREATE TABLE board2(
seq INT NOT NULL AUTO_INCREMENT, 
title CHAR(100) NOT NULL, -- 컬럼레벨 정의
contents TEXT, -- 65536byte
viewcount INT DEFAULT 0, -- 컬럼레벨 정의
writer CHAR(10), 
CONSTRAINT fk_board_seq PRIMARY KEY(seq), -- 오류아닌 경고가 나온다. pk의 경우 우리가 준 이름(fk_board_seq) 무시하고 PRIMARY로 나옴
CONSTRAINT fk_board_writer2 FOREIGN KEY(writer) REFERENCES user_info(user_id) -- 테이블레벨 정의

);
DESC board2;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME = "board2";

INSERT INTO board2(title, contents, writer) VALUES("제목", "내용", "Maria");
INSERT INTO board2(title, contents, writer) VALUES("제목2", "내용2", "Maria2");
-- DELETE FROM user_info WHERE user_id = "maria";
SELECT * FROM user_info;
UPDATE board2 SET writer = "maria" WHERE title = "제목";
UPDATE board2 SET writer = "maria2" WHERE title = "제목2";
SELECT * FROM board2;

DELETE FROM user_info WHERE user_id = "maria"; 
ALTER TABLE board2 DROP CONSTRAINT fk_board_writer2;
ALTER TABLE board2 ADD CONSTRAINT fk_board_writer2
FOREIGN KEY(writer) REFERENCES user_info(user_id)
ON DELETE CASCADE ON UPDATE cascade;
SELECT * FROM user_info;

SELECT * FROM board;
INSERT INTO board(title, contents, writer) VALUES("새제목2","새내용2","maria2");
INSERT INTO board(title, contents, writer) VALUES("새제목","새내용","maria2");
INSERT INTO board(title, writer) VALUES("새제목","maria3");

ALTER TABLE board MODIFY contents text NOT NULL;
ALTER TABLE board ADD writingtime DATETIME;
DESC board;


-- 서브쿼리의 예시
-- first_name이 Kelly인 사원과 동일 부서 근무자의 부서코드, 급여, 이름 조회
DESC employees;
SELECT department_id, salary, first_name
FROM employees
WHERE department_id = 50;

SELECT department_id, salary, first_name
FROM employees
WHERE department_id = (SELECT department_id FROM employees WHERE first_name = "peter"); 
-- 오류 발생.. peter 총 3명으로 1개 이상의 행을 불러냄..
-- 다중행의 경우 subquery --> IN 사용
SELECT department_id, salary, first_name
FROM employees
WHERE department_id IN (SELECT department_id FROM employees WHERE first_name = "peter"); 

SELECT * FROM employees;

-- 최대 급여 조회
SELECT MAX(salary) FROM employees;

-- 최대 급여 부서별 조회
SELECT department_id, FIRST_name, MAX(salary) FROM employees 
GROUP BY department_id;

-- 최소급여자인 이름 조회
SELECT first_name, min(salary) FROM employees;
-- Steven은 최소 급여자가 아님에도 잘못 도출됨(오류발생x)
SELECT first_name, salary FROM employees
WHERE salary = (SELECT min(salary) FROM employees);

-- peter 와 같은 부서이고, 입사일도 일치하는 사원의 부서코드, 급여, 이름 조회
SELECT department_id, salary, first_name, hire_date
FROM employees
WHERE department_id IN (SELECT department_id FROM employees WHERE first_name = "peter")
AND hire_date IN (SELECT hire_date FROM employees WHERE first_name = "peter");
-- 이하 다중열 subquery
SELECT department_id, salary, first_name, hire_date
FROM employees
WHERE (department_id, job_id) IN (SELECT department_id, job_id FROM employees WHERE first_name = "kelly");
