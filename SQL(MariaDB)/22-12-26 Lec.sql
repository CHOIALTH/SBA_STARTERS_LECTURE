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

