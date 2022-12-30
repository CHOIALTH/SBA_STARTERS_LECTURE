SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 100;
DELETE FROM emp_copy WHERE EMPLOYEE_ID = 100;
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 100;
ROLLBACK;
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 100;

SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 101;
DELETE FROM emp_copy WHERE EMPLOYEE_ID = 101;
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 101;
ROLLBACK;
SELECT * FROM emp_copy WHERE EMPLOYEE_ID = 101;

COMMIT;
SELECT * FROM account_tbl;

CREATE USER jdbc IDENTIFIED BY 'jdbc';
DROP USER jdbc;
CREATE DATABASE memberdb;
DROP DATABASE memberdb;
GRANT ALL privilleges ON memberdb.* TO jdbc@'%';
-- memberdb.* : sql 기능 다 허용하겠다
--  memberdb.select : select만 허용하겠다 .. 











