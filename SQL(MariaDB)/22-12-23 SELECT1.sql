SELECT * FROM employees;

DESCRIBE employees;

SELECT first_name, salary FROM employees;

SELECT first_name, salary '월봉', salary * 12 AS '연봉' FROM employees;
-- 연봉, salary * 12
SELECT FIRST_name, department_id FROM employees;

SHOW DATABASES;
DESC employees; 

SELECT employee_id, salary, first_name FROM employees WHERE salary >= 10000 AND employee_id < 200;

-- s로 시작하는 사원 first_name 조회
SELECT first_name
FROM employees
where first_name LIKE 's%';

-- er로 끝나는 사원 first_name 조회
SELECT first_name
FROM employees
where first_name LIKE '%er';

-- '2002-06-07 00:00:00'
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '_____06%'; 

-- 커미션 받는 사원
SELECT first_name, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT employee_id FROM employees ORDER BY employee_id LIMIT 10, 10;
-- null이 우선하여 출력된다.
SELECT employee_id, commission_pct FROM employees ORDER BY commission_pct;
-- null 나중

SELECT employee_id, commission_pct FROM employees ORDER BY commission_pct DESC;
-- null 나중, 역순(오라클에선 적용O MariaDB에선 X
SELECT employee_id, commission_pct FROM employees ORDER BY commission_pct DESC NULLs FIRST;
-- 부서코드 오름차순, 동일 부서코드인 경우 급여 많은 사원부터 조회.
SELECT first_name, salary, department_id FROM employees ORDER BY department_id, salary DESC																																																	;


SELECT employee_id
FROM employees
ORDER by employee_id -- 줄 세웠고
LIMIT 0,4; -- [0]부터 4개 추출

-- 사원이름, 전체사원 급여 총합조회
-- 집계함수 외 SELECT 다른 컬럼 조회 불가
SELECT FIRST_NAME, SUM(SALARY) FROM employees;

-- 부서코드 종류 개수
SELECT COUNT(DISTINCT DEPARTMENT_ID) FROM employees;

-- 50번 부서 사원 급여 총합 조회
SELECT SUM(SALARY)
FROM employees
WHERE DEPARTMENT_ID = 50;

-- 각 부서별 부서 사원 급여총합 조회
-- 집계함수 외 SELECT 다른 컬럼 조회 불가
-- 단 GROUP BY 컬럼 제외
SELECT DEPARTMENT_ID, SUM(SALARY)
FROM employees
GROUP BY DEPARTMENT_ID;

-- 각 부서별 부서 사원 급여총합 조회(단 부서코드 없는 사원 조회)
SELECT DEPARTMENT_ID, SUM(SALARY)
FROM employees
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID;

-- 각 부서별,직종별  부서 사원 급여 총합 조회(단 부서코드 없는 사원 조회)
SELECT DEPARTMENT_ID, JOB_ID, SUM(SALARY)
FROM employees
WHERE DEPARTMENT_ID IS NOT NULL 
-- AND JOB_ID IS NOT NULL (현 데이터에서는 NULL값없으므로 안써도 무방)
GROUP BY DEPARTMENT_ID, JOB_ID;

-- 각 부서별 부서 사원 급여총합 조회
-- 단, 부서코드 없는 사원 제외하고, 급여총합 10만 이상인 부서만 조회
SELECT DEPARTMENT_ID, SUM(SALARY)
FROM employeesempdb
WHERE DEPARTMENT_ID IS NOT NULL 
GROUP BY DEPARTMENT_ID
HAVING SUM(SALARY) >= 100000
-- GROUP BY가 실행되야 알 수 있는 조건은 HAVING 사용
-- WHERE절은 GROUP BY 앞& 통계대상 레코드의 조건을 제한
-- HAVING절은GROUP BY 다음 & 이미 집계한 결과의 조건을 제한
ORDER BY SUM(SALARY) ASC; 






