-- 변수 사용
SET @NAME = 'KELLY';

SELECT first_name, salary
FROM employees
WHERE salary > (SELECT salary FROM employees WHERE first_name = @NAME);

SET @NAME2 = 'PETER';

SELECT first_name, salary
FROM employees
WHERE salary > ANY (SELECT salary FROM employees WHERE first_name = @NAME2);

-- 부서의 최대 급여인 사원 이름, 급여, 부서명  조회
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM employees
WHERE (DEPARTMENT_ID, SALARY) = ANY (SELECT DEPARTMENT_ID, MAX(SALARY) FROM employees GROUP BY DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID;

SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM employees
WHERE (DEPARTMENT_ID, SALARY) IN (SELECT DEPARTMENT_ID, MAX(SALARY) FROM employees GROUP BY DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID;

-- LOCATIONS 테이블 : 부서 위치, 도시 정보
-- DEPARTMENTS 테이블 : 부서이름, 부서장, 도시코드
-- EMPLOYEES 테이블 : 사원이름..... 부서코드

-- SUBQUERY 중첩 - 테이블 여러개 필요

-- 런던 도시 근무 사원명 조회
-- 1. 런던 도시코드 조회 -> 2400번
SELECT LOCATION_ID FROM locations WHERE CITY = "LONDON";

-- 2. 런던과 도시코드 같은 도시코드 부서코드 조회 -> 40번
SELECT * FROM departments;
SELECT LOCATION_ID, DEPARTMENT_ID FROM departments WHERE LOCATION_ID = 2400;

-- 3. 
SELECT FIRST_NAME, DEPARTMENT_ID FROM employees
WHERE DEPARTMENT_ID = 
(SELECT DEPARTMENT_ID FROM departments WHERE LOCATION_ID =
	(SELECT LOCATION_ID FROM locations WHERE CITY = "SOUTH SAN FRANCISCO")
);
	
-- 각 부서별 최대급여 이름, 급여, 부서번호 조회

-- 부서의 평균 급여보다 더 많이 받는 사원의 이름,급여,부서번호 조회
/* 
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE (DEPARTMENT_ID, SALARY) > ANY
(SELECT DEPARTMENT_ID, AVG(SALARY) FROM employees GROUP BY DEPARTMENT_ID);
*/

/* 
SELECT SALARY, DEPARTMENT_ID,
(SELECT AVG(SALARY) FROM employees WHERE e.DEPARTMENT_ID = DEPARTMENT_ID )
FROM employees e
WHERE SALARY > ANY (SELECT AVG(SALARY) FROM employees GROUP BY DEPARTMENT_ID);
*/

-- INLINE VIEW
/*SELECT (SELECT)
FROM (SELECT 결과 1개 가상 테이블 - INLINE VIEW)
WHERE(SELECT)
*/
-- 10000 이상 평균 급여
SELECT AVG(SALARY)
FROM employees
WHERE SALARY >= 10000;

-- 회사 DB 부서별 권한 다르게
SELECT SAL_TBL.AVG_SAL AS 고액월급평균
FROM(SELECT AVG(SALARY) AVG_SAL FROM employees WHERE SALARY >= 10000) SAL_TBL;
-- SAL_TBL은 가상테이블 이름을 임의로 만든것
-- AVG_SAL

-- 급여 수준에 따른 직급 조회
-- EMPLOYEES 테이블에 급여컬럼 있고, 직급컬럼은 ㅇ벗다
-- 직급 급여 20000 이상 : 임원 / 15000이상 : 부장 / 10000 이상 : 과장 / 5000 이상 : 대리 / 이하 사원
-- 급여 : SALARY + SALARY * COMMISSION_PCT
SELECT * FROM employees;

SELECT MAX(SALARY), MIN(SALARY) FROM employees;

SELECT FIRST_NAME, 
CASE
WHEN IMSISAL >= 20000 THEN '임원' 
WHEN IMSISAL >= 15000 THEN '부장'
WHEN IMSISAL >= 10000 THEN '과장'
WHEN IMSISAL >= 5000 THEN '대리'
ELSE "사원"
END 직급 -- 직급이라는 컬럼 만든다
FROM (SELECT FIRST_NAME, SALARY + SALARY * IFNULL(COMMISSION_PCT, 0.1) AS IMSISAL FROM employees) IMSITBL; 

-- 일반적으로 NULL값을 가진 컬럼은 연산식에 포함시 결과도 NULL 처리됨.. -> IFNULL함수 다른값 변경 연산
-- 연산식 반복시 위와같이 구성하면 좋다

SELECT FIRST_NAME, (SELECT MIN(SALARY) FROM employees) AS 최소급여 FROM employees;

-- KELLY와 같은 부서의 사원의 사원의 부서를 100번으로 이동
SELECT FIRST_NAME, DEPARTMENT_ID FROM emp_copy WHERE DEPARTMENT_ID = 100;

UPDATE emp_copy 
SET DEPARTMENT_ID = 100
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM employees WHERE FIRST_NAME = "KELLY");


-- 100번 부서원을 SUSAN의 부서로 이동
SELECT DEPARTMENT_ID FROM emp_copy WHERE DEPARTMENT_ID = 100;
SELECT DEPARTMENT_ID FROM emp_copy WHERE FIRST_NAME = "SUSAN";

UPDATE emp_copy
SET DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM emp_copy WHERE FIRST_NAME = "SUSAN")
WHERE DEPARTMENT_ID = 100;

SELECT * FROM emp_copy;


-- 테이블 조합
-- 2개 물리적 테이블 나눠져있다가 / SELECT시 합쳐서 조회
-- 조합테이블의 컬럼 개수, 타입, 순서 일치해야
-- UNION : 합집합 
-- UNION ALL : UNION과 거의 같은 기능 수행.. BUT UNION과 달리 중복제거와 정렬을 하지 X. 단순히 데이터 연결만 함
-- INTERSECT : 교집합  / MINUS(MariaDB 제외.. MariaDB에선 EXCEPT 사용) : 차집합
    
-- 50번 부서의 모든 부서원 복사 emp_dept_50 테이블 생성!
CREATE TABLE emp_dept_50
(SELECT * FROM employees WHERE DEPARTMENT_ID = 50);

SELECT * FROM emp_dept_50;

-- MANAGER 계열 직종 사원들을 emp_job_man 테이블 생성
-- job_id - it_prog, st_man, it_man

CREATE TABLE emp_job_man
(SELECT * FROM employees WHERE job_id LIKE "%man%");

SELECT * FROM emp_job_man;

-- 재난지원금을 지원하려고함
-- 대상은 50번 부서원이거나 MANAGER 직종으로 한정

SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_dept_50
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_job_man
ORDER BY 1; 
-- 두 테이블 합병!

SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_dept_50
UNION ALL
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_job_man
ORDER BY 1; 
-- 50부서이면서 MANAGER직종인 것을 중복으로 받아오게 됨.
-- 중복제거나 정렬을 하지 X

-- 대상은 50부서인데, 이 중 manager 직종은 제외하고 조회해본다!


SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_dept_50
except
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_job_man;

SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_job_man
except
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
FROM emp_dept_50;

-- 집합연산자 : 2개 테이블의 행 개수 합병 - 행 개수 변화
-- JOIN : 2개 테이블 컬럼 개수 합병 - 1개 레코드 열 개수 변화
-- SUBQUERY, JOIN QUERY


-- 사원명 부서명 조회
SELECT FIRST_NAME, DEPARTMENT_ID FROM employees;

SELECT DEPARTMENT_NAME, DEPARTMENT_ FROM departments;


SELECT FIRST_NAME, DEPARTMENT_NAME 
FROM employees INNER JOIN departments
ON employees.department_id = departments.department_id;

SELECT FIRST_NAME, DEPARTMENT_NAME 
FROM employees JOIN departments
ON employees.department_id = departments.department_id;

SELECT e.FIRST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_ID,d.DEPARTMENT_NAME
-- DEPARTMENT_ID 앞에는 departments / d 와도 무방
-- FIRST_NAME과 DEPARTMENT_NAME 의 앞에 붙은 테이블명. 은 생략 가능(각각 테이블에만 있는 고유한 거니까)
FROM employees e JOIN departments d
-- e와 d는 이 문장 내에서만 사용 가능
ON e.department_id = d.department_id;

SELECT DEPARTMENT_NAME, DEPARTMENT_ID FROM departments;


-- JOBS -> JOB_ID --> IT_PROG, .... --> JOB_TITLE
-- EMPLOYEES -> JOB_ID REFERENCES JOBS(JOB_ID)

SELECT * FROM jobs;
SELECT * FROM employees;
-- 사원이름, 직종이름, 급여조회
SELECT e.first_name AS 사원이름, j.job_title AS 직종이름, e.salary AS 급여
FROM employees e JOIN jobs j
ON e.job_id = j.job_id;

-- 사원이름,직종이름, 부서이름 조회
-- 단, 급여 10000 이상인 사원만 대상

SELECT FIRST_NAME, JOB_TITLE, DEPARTMENT_NAME, SALARY
FROM employees e 
JOIN jobs j
JOIN departments d 
ON e.department_id = d.department_id
WHERE SALARY >= 10000;


-- SUBQUERY 중첩
-- SEATTLE 도시 근무 사원의 사원명, 부서명, 도시명 조회
SELECT * FROM locations; 
SELECT * FROM departments;
SELECT FIRST_NAME, DEPARTMENT_NAME, CITY
FROM locations l 
JOIN departments d -- 모든 JOIN은 공통되는 컬럼이 있어야.. 이 경우 LOCATION_ID 
ON l.location_id = d.location_id
JOIN employees e 
ON d.department_id = e.department_id
WHERE CITY = "SEATTLE";


SELECT FIRST_NAME, DEPARTMENT_NAME
FROM employees e
JOIN departments d
ON e.department_id = d.department_id;

SELECT *
FROM employees
WHERE DEPARTMENT_ID IS NULL;


-- 조건 범위 외부에 있어도 조인
-- 부서 배정되지 않은 사원도 포함하여 조인

SELECT FIRST_NAME, DEPARTMENT_NAME
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id;

SELECT * FROM departments;
-- 부서명 사원명 조회. 단, 명의 사원도 소속되지않은 부서도 포함하여 조인
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM employees e RIGHT OUTER JOIN departments d ON e.department_id = d.department_id;

-- 부서명,사원명 조회. 단 1명의 사원도 소속되지않은 부서도, 소속부서 없는 사원도 포함하여 조인
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id
UNION
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM employees e RIGHT OUTER JOIN departments d ON e.department_id = d.department_id;


SELECT e.*, DEPARTMENT_NAME
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id;

-- SUBQUERY와 JOIN은 같은결과 쿼리
SELECT
FROM (SELECT - INLINE VIEW);


-- SEATTLE에서 근무하는 사원의 이름, 부서명, 국가 대륙조회
SELECT INFORM.EMP, DEPART, RE
FROM (
SELECT FIRST_NAME EMP, DEPARTMENT_NAME DEPART, COUNTRY_NAME COUN, REGION_NAME re
FROM employees e
JOIN departments d ON e.DEPARTMENT_ID = d.department_id
JOIN locations l ON d.location_id = l.location_id
JOIN countries c ON l.country_id = c.country_id
JOIN regions r ON c.region_id = r.region_id
WHERE l.CITY = "SEATTLE"
)
INFORM;

DESC employees;

SELECT EMPLOYEE_ID, MANAGER_ID FROM employees;

-- 각 사원의 정보 중에서 상사 사번 컬럼 포함
-- 내 상사의 이름, 급여 조회

SELECT MANAGER_ID FROM employees WHERE EMPLOYEE_ID = 150; -- 101 출력
SELECT FIRST_NAME, SALARY, EMPLOYEE_ID FROM employees WHERE EMPLOYEE_ID = 145;

SELECT FIRST_NAME, SALARY, EMPLOYEE_ID FROM employees
WHERE EMPLOYEE_ID = (SELECT MANAGER_ID FROM employees WHERE EMPLOYEE_ID = 150);
-- 내 상사

SELECT FIRST_NAME, SALARY, EMPLOYEE_ID FROM employees
WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM employees WHERE EMPLOYEE_ID = 150);


-- SELF JOIN
SELECT ME.employee_id 내사번, ME.FIRST_NAME 내이름, 
ME.manager_id 상사사번, ME.employee_id 상사사번2, 
MAN.FIRST_NAME 상사이름
FROM employees ME 
JOIN employees MAN
ON ME.manager_id = MAN.manager_id;

SELECT * FROM employees;

-- 내 사번 내 이름 상사사번 상사이름 조회하되 상사없는 사원 포함하여 조회
SELECT * FROM employees WHERE MANAGER_ID IS NULL;

SELECT MY.employee_id 내사번, MY.first_name 내이름, 
MN.employee_id 상사사번, MN.manager_id 상사사번2,
MN.first_name 상사이름
FROM employees MY
LEFT OUTER JOIN employees MN
ON MY.manager_id = MN.employee_id;

SELECT MY.employee_id 내사번, MY.first_name 내이름, 
MN.employee_id 상사사번, MN.manager_id 상사사번2,
MN.first_name 상사이름
FROM employees MY
RIGHT OUTER JOIN employees MN
ON MY.manager_id = MN.employee_id;

SELECT MY.employee_id 내사번, MY.first_name 내이름, 
MN.employee_id 상사사번, MN.manager_id 상사사번2,
MN.first_name 상사이름
FROM employees MY
LEFT OUTER JOIN employees MN
ON MY.manager_id = MN.employee_id;






















