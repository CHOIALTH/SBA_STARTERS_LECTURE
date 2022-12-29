-- MariaDB day4 트랜잭션

SHOW VARIABLES LIKE '%AUTO%';  
SET AUTOCOMMIT = FALSE;
-- 오토커밋 꺼져있어야 롤백 가능!


-- EMPCOMNNECTION
DROP TABLE emp_copy;

CREATE TABLE emp_copy
(SELECT employee_id, first_name, last_name, salary, hire_date, department_id 
FROM employees);

SELECT * FROM emp_copy;

SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 100;
DELETE FROM emp_copy WHERE EMPLOYEE_ID = 100; 
-- EMPCONNECTION 상에선 삭제된 것 같지만, ROOTCONNECTION에는 남아있다.
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 100;
ROLLBACK;
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 100;

SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 101;
DELETE FROM emp_copy WHERE EMPLOYEE_ID = 101;
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 101;
COMMIT; -- EMP버퍼 -> DB에 반영된다.
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 101;

-- 따라서 COMMIT / ROLLBACK 전에는 완전히 삭제된 것이 아니다.

CREATE TABLE account_tbl(
account_number CHAR(10) PRIMARY KEY,
account_pw INT,
balance DECIMAL(10, 2)
-- DECIMAL(p,[s])
-- 고정 정밀도(p)와 배율(s)을 가진 숫자형.
-- DECIMAL(10, 2) : 전체자릿수 10 / 그 중 소수점 이하 : 2자리
);
INSERT INTO account_tbl
VALUES('a', 1111, 10000);
INSERT INTO account_tbl
VALUES('b', 2222, 0);

COMMIT;

SELECT * FROM ACCOUNT_TBL; 

SET AUTOCOMMIT = TRUE;
SHOW VARIABLES LIKE '%AUTO%';

UPDATE ACCOUNT_TBL
SET BALANCE = BALANCE - 5000
WHERE ACCOUNT_NUMBER = "a";

UPDATE ACCOUNT_TBL
SET BALANCE = BALANCE +5000
WHERE ACCOUNT_NUMBER = "bB";

ROLLBACK;
-- 오토커밋 TRUE 하니 ROLLBACK 안먹는다 ㅜㅜ
-- 트랜잭션 
SELECT * FROM ACCOUNT_TBL;
DROP TABLE ACCOUNT_TBL;


SET AUTOCOMMIT = FALSE;
SHOW VARIABLES LIKE '%AUTO%';

UPDATE ACCOUNT_TBL
SET BALANCE = BALANCE - 5000
WHERE ACCOUNT_NUMBER = "a";

UPDATE ACCOUNT_TBL
SET BALANCE = BALANCE +5000
WHERE ACCOUNT_NUMBER = "bB";

ROLLBACK;
-- 오토커밋 TRUE 하니 ROLLBACK 안먹는다 ㅜㅜ
SELECT * FROM ACCOUNT_TBL;

INSERT INTO account_tbl
VALUES('c', 33333, 0);

SELECT * FROM emp_copy WHERE employee_id >= 400;

SELECT * FROM product;

SELECT * FROM user_INFO;

INSERT INTO user_info VALUES
('db', 'db', '김전문', 'jun@kil.com', '010-11112222', '서울시 용산구 새싹'),
('oracl', 'oracl', '최전문', 'jun1@kil.com', '010-11112222', '서울시 용산구 새싹'),
('mysql', 'mysql', '박전문', 'jun2@kil.com', '010-11112222', '제주시 제주동  새싹'),
('sqlse', 'sqlse', '김전문', 'jun3@kil.com', '010-11112222', '부산시 용산구 새싹')
;






















