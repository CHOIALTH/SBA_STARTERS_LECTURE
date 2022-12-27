USE empdb;
SELECT * FROM employees;
-- ex) Kelly 급여 같은 사원의 이름, 급여 조회
SELECT first_name, salary
FROM employees
WHERE salary = (SELECT salary FROM employees WHERE first_name = 'kelly');

-- ex) Kelly 보다 급여 더 많이 받는 사원의 이름, 급여 조회
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT salary FROM employees WHERE first_name = 'kelly');

-- ex) William 보다 급여 더 많이 받는 사원의 이름, 급여 조회
SELECT salary FROM employees WHERE first_name = 'william'; -- 7400 / 8300 조회됨

SELECT first_name, salary
FROM employees
WHERE salary > all (SELECT salary FROM employees WHERE first_name = 'william');
-- 여기서 all은 '크다'는 의미!
-- 이 쿼리문은 8300보다 큰 값만 조회됨
SELECT first_name, salary
FROM employees
WHERE salary > any (SELECT salary FROM employees WHERE first_name = 'william');
-- 이 쿼리문은 7400 / 8300 중 7400보다 큰 값 조회됨 

-- ex) William과 같은 급여 받는 사원의 이름, 급여 조회
SELECT first_name, salary
FROM employees
WHERE salary in (SELECT salary FROM employees WHERE first_name = 'william');
-- 동등비교시 where salary in / where salary = any 둘 중 써야함
-- where salary all 은 아무것도 조회하지 못함


