DESCRIBE employees;
SELECT * FROM employees;
DESCRIBE countries;
DESCRIBE departments;
SELECT * FROM departments;
DESCRIBE jobs;
DESCRIBE locations;
DESCRIBE regions;
-- 기본--
SELECT first_name AS "이름", salary * 12 AS "월급의 12배" FROM employees WHERE salary * 12 >= 170000; 

SELECT first_name, salary FROM employees WHERE manager_id IS NULL;

SELECT first_name, salary, hire_date FROM employees WHERE YEAR(hire_date) < 2004;

SELECT department_id, department_name FROM departments;

SELECT job_id, job_title FROM jobs;

-- 논리연산자--
SELECT first_name, salary, department_id FROM employees WHERE department_id = 80 AND salary >= 13000 or department_id = 50 AND salary >= 13000;

SELECT first_name, salary, department_id, hire_date FROM employees WHERE YEAR(hire_date) > 2005 AND salary >= 1300 AND salary <= 20000;

-- SQL 비교연산자--
SELECT first_name, salary, department_id, hire_date FROM employees WHERE YEAR(hire_date) = 2005;

SELECT first_name salray, job_id FROM employees WHERE job_id LIKE '%clerk%';
-- like '%특정문자%' : 특정문자 포함하는 모든 경우 / like '%특정문자', like '특정문자% : 특정문자를 뒤/ 앞에 포함하는 경우
SELECT first_name, salary, hire_date FROM employees WHERE MONTH(hire_date) = 12;

SELECT first_name, salary, hire_date FROM employees WHERE first_name LIKE '%le%';

SELECT first_name, salary, hire_date FROM employees WHERE first_name LIKE '%m';

SELECT first_name, salary, hire_date FROM employees WHERE first_name LIKE '__d%';

SELECT first_name, commission_pct, salary FROM employees WHERE commission_pct IS NOT NULL;

SELECT first_name, commission_pct, salary FROM employees WHERE commission_pct IS NULL;

-- 기타 --
SELECT first_name, salary, hire_date,commission_pct FROM employees WHERE (department_id = 30 OR department_id = 50 OR department_id = 80) AND commission_pct IS NOT null ORDER BY hire_date ASC;
-- or 조건문 여러개 주고 그 뒤에 and 쓰려면 () 활용하여 or 먼저 묶어보자

SELECT department_id, max(salary) AS "최대급여", min(salary) AS "최소급여" FROM employees GROUP BY department_id HAVING MAX(salary) != MIN(salary);

SELECT department_id, COUNT(first_name) AS "부서별 인원수" FROM employees GROUP BY department_id HAVING COUNT(department_id) > 5;