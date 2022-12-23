SELECT * FROM employees;

DESCRIBE employees;

SELECT first_name, salary FROM employees;

SELECT first_name, salary '월봉', salary * 12 AS '연봉' FROM employees;
-- 연봉, salary * 12
SELECT FIRST_name, department_id FROM employees;