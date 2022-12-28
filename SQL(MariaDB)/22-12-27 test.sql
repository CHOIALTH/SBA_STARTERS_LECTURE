USE EMPDB;
SELECT * FROM employees;
SELECT * FROM departments;
SELECT * FROM locations;
SELECT * FROM jobs;
SELECT * FROM regions;
SELECT * FROM countries;
-- 완 1. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
SELECT FIRST_NAME, DEPARTMENT_ID, SALARY
FROM employees 
WHERE SALARY > (SELECT AVG(SALARY) FROM employees WHERE DEPARTMENT_ID = 80); 
-- 80번 부서의 평균(8955.~~~~)만 구하면 되니까 GROUP BY 사용할 필요X


-- 완 2. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명,부서id를 조회하시오.
SELECT FIRST_NAME, SALARY, DEPARTMENT_NAME, e.DEPARTMENT_ID
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
WHERE salary > ALL (SELECT MIN(SALARY) FROM employees WHERE department_id 
= (SELECT department_id FROM departments WHERE location_id 
= (SELECT LOCATION_ID FROM locations WHERE CITY = 'South San Francisco'))) -- 'South San Francisco' 최소 급여 2100
AND SALARY > (SELECT AVG(SALARY) FROM employees WHERE DEPARTMENT_ID = 50); -- 50번 부서 평균급어 : 3475.~~

-- 완 3-1.각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도 출력결과에 포함시키시오. 
-- SELECT FIRST_NAME, e.EMPLOYEE_ID, j.JOB_TITLE
SELECT COUNT(j.job_id) AS 직급별인원수, JOB_TITLE AS 직급명, e.JOB_ID
FROM employees e
RIGHT OUTER JOIN jobs j
ON e.job_id = j.job_id
GROUP BY JOB_TITLE;

SELECT JOB_TITLE, COUNT(*)
FROM jobs j 
LEFT OUTER JOIN employees e 
ON j.job_id = e.job_id
GROUP BY JOB_TITLE;

-- 이 문제의 경우 사용되지 않은 직급이 없음


-- 완 3-2. 직급별 인원수가 10명 이상인 직급만 출력결과에 포함시키시오.
SELECT COUNT(j.job_id) AS 직급별인원수, JOB_TITLE AS 직급명, e.JOB_ID
FROM employees e
RIGHT OUTER JOIN jobs j
ON e.job_id = j.job_id
GROUP BY JOB_ID
HAVING COUNT(j.job_id) >= 10;

SELECT job_title, COUNT(*)
FROM jobs j LEFT OUTER JOIN employees e ON e.job_id = j.job_id
GROUP BY job_title
HAVING COUNT(*) >= 10;


-- 4. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.
SELECT FIRST_NAME, DEPARTMENT_NAME, e.department_id, MAX(e.salary), MIN(e.salary)
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
-- WHERE salary = MAX(e.salary)
GROUP BY e.department_id
HAVING salary = MAX(salary)
;

SELECT first_name AS "부서별 최대급여자", department_name, salary
-- alias 별명 설정시 공백 사용하려면 "" 로 묶어주면 된다.
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE (e.department_id, salary) in
(SELECT department_id, MAX(salary) FROM employees GROUP BY department_id)
;



-- 5. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 최소급여를 마지막에 포함시켜 출력 하시오.
SELECT * FROM employees;
SELECT e.FIRST_NAME, e.department_id, e.SALARY, 
e2.SALARY = ANY(SELECT MIN(e.SALARY) FROM employees WHERE e.department_id = e2.department_id ) AS 해당부서최소급여
-- MIN(e.SALARY) AS 해당부서최소급여
FROM employees e
INNER JOIN employees e2
ON e.department_id = e2.department_id
GROUP BY DEPARTMENT_ID;

SELECT first_name "직원 이름", department_id 부서코드, salary "내 급여", 
(SELECT MIN(salary) FROM employees WHERE e.department_id = department_id) "소속 부서의 최소급여"
-- 이경우 ()안에  GROUP BY department_id는 원하는 답 마주할 수 없음
FROM employees e

;



-- 완  6. 월별 입사자 수를 조회하되, 입사자 수가 10명 이상인 월만 출력하시오.
SELECT MONTH(HIRE_DATE) 월, COUNT(MONTH(HIRE_DATE)) "월별 입사자수"
FROM employees 
GROUP BY MONTH(HIRE_DATE)
HAVING COUNT(MONTH(HIRE_DATE)) >= 10
;

SELECT hire_month, COUNT(hire_month)
FROM  (SELECT 
case 
-- 여기서 _ 는 각 5개 (xxxx- 영역이니까)
when hire_date LIKE '_____01%' then '01'
when hire_date LIKE '_____02%' then '02'
when hire_date LIKE '_____03%' then '03'
when hire_date LIKE '_____04%' then '04'
when hire_date LIKE '_____05%' then '05'
when hire_date LIKE '_____06%' then '06'
when hire_date LIKE '_____07%' then '07'
when hire_date LIKE '_____08%' then '08'
when hire_date LIKE '_____09%' then '09'
when hire_date LIKE '_____10%' then '10'
when hire_date LIKE '_____11%' then '11'
when hire_date LIKE '_____12%' then '12'
END hire_month FROM employees) imsi
-- imsi 라는 가상의 테이블에 hire_month 라는 컬럼을 담음
GROUP BY hire_month
HAVING COUNT(hire_month) >= 10
ORDER BY 1;



-- 완 7. 자신의 관리자(상사)보다 많은 급여를 받는 직원의 이름과 급여를 조회하시오.
SELECT MY.first_name, MY.salary "내 급여", BO.salary "상사 급여"
FROM employees MY
LEFT OUTER JOIN employees BO
ON MY.manager_id = BO.manager_id
WHERE MY.salary > BO.salary;

-- 완 8. 'Southlake'에서 근무하는 직원의 이름, 급여, 직책(job_title)을 조회하시오. 총 5명
SELECT FIRST_NAME, SALARY, JOB_TITLE, l.city
FROM jobs j 
JOIN employees e
ON j.job_id = e.job_id
JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
WHERE city = 'Southlake'
;
-- 킴벌리 부서null로 집계 안된다..



-- 완 9. 국가별 근무 인원수를 조회하시오. 단, 인원수가 3명 이상인 국가정보만 출력되어야함.
SELECT c.country_id AS 국가, COUNT(c.country_id) AS 국가별근무인원수
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
JOIN countries c
ON l.country_id = c.country_id 
GROUP BY c.country_id
HAVING COUNT(c.country_id) >= 3;
-- HAVING COUNT(*) >= 3; 해도 상관없음

-- 완 10. 직원의 폰번호, 이메일과 상사의 폰번호, 이메일을 조회하시오. 단, 상사가 없는 직원은 '<관리자 없음>'이 출력되도록 해야 한다.
SELECT * FROM employees;

SELECT MY.phone_number AS 직원폰번, MY.email AS 직원멜,
IFNULL(BO.phone_number, "<관리자 없음>") 상사폰번,
IFNULL(BO.email, "<관리자 없음>") 상사이멜
FROM employees MY
LEFT OUTER JOIN employees BO
-- 상사가 없는 직원 출력 위해 외부조인
ON MY.manager_id = BO.employee_id;

-- 완 11. 각 부서 이름별로 최대급여와 최소급여를 조회하시오. 단, 최대/최소급여가 동일한 부서는 출력결과에서 제외시킨다.
SELECT department_name AS 부서명, e.department_id AS 부서ID,  MAX(e.salary) AS 최대급여, MIN(e.salary) AS 최소급여
FROM employees e
JOIN departments d
ON e.department_id = d.department_id
GROUP BY e.department_id
;

SELECT DEPARTMENT_NAME, MAX(SALARY), MIN(SALARY)
FROM departments D JOIN employees E ON D.department_id = E.department_id
GROUP BY DEPARTMENT_NAME
HAVING MAX(SALARY) != MIN(SALARY);

-- 12. 부서별, 직급별 평균급여를 조회하시오. 
--    단, 평균급여가 50번부서의 평균보다 많은 부서만 출력되어야 합니다.
SELECT department_name AS 부서명, e.department_id AS 부서ID,  AVG(e.salary) AS 부서별평균급여,
j.job_title AS 직급명
FROM jobs j
JOIN employees e 
ON j.job_id = e.job_id
JOIN departments d
ON e.department_id = d.department_id
GROUP BY e.department_id, j.job_id
-- HAVING 
;

SELECT DEPARTMENT_ID, JOB_ID, AVG(SALARY)
FROM employees E
GROUP BY DEPARTMENT_ID, JOB_ID
HAVING AVG(SALARY) > (SELECT AVG(SALARY) FROM employees WHERE DEPARTMENT_ID = 50)
-- SELECT AVG(SALARY) FROM employees WHERE DEPARTMENT_ID = 50 --> 3475.555556
;
