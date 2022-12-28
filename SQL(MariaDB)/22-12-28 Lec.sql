USE EMPDB; 
-- 22-12-28 LEC
-- 숫자함수
-- 1) 정수 tinyint(1byte) / smallint(2) / int(4) / long(8) 
-- ex) 상품코드 2자리수로 제한하겠다.. smallint로도 충분히 가능

-- 2) 실수 float(4) / double(8)

-- 3) 사용자 구성 decimal (10, 0), decimal(8, 2)


SELECT AVG(SALARY), ROUND(AVG(SALARY)), ROUND(AVG(SALARY),3), TRUNCATE(AVG(SALARY),2)
-- 평균급여, 반올림, 반올림(소숫점3자리), 절삭(소숫점2자리)
FROM employees;
SELECT 123.5678, ROUND(123.5678,0), ROUND(123.5678,-1), ROUND(123.5678,-2);

SELECT 1234, MOD(1234,3), MOD(123,7), MOD(12,3);

SELECT FIRST_NAME, EMPLOYEE_ID 
FROM employees 
WHERE MOD(EMPLOYEE_ID, 2) = 0;
-- 짝수사번 출력

SELECT FIRST_NAME, EMPLOYEE_ID,
CASE 
WHEN MOD(EMPLOYEE_ID, 2) = 0 THEN "짝수사번"
ELSE "홀수사번" -- 모든 CASE문은 END로 끝내야한다!!
END "사번의 성격" 
FROM employees;


-- 이상 MOD 활용



-- 문자함수
-- 256자리 -> CHAR / VARCHAR
-- 65536자리 -> TEXT

CREATE TABLE productFUNC(
NAME CHAR(100),
PRICE DECIMAL(10, 2),
DETAIL TEXT,
IMAGEFILE VARCHAR(100));


INSERT INTO productfunc VALUES('COMPUTER', 1000.99, '.......', 'COM.JPG');
SELECT * FROM productfunc;

SELECT ASCII('A'), CHAR(65);

SELECT "ABCDEF", "가나다라마바", 
BIT_LENGTH("ABCDEF"), LENGTH("ABCDEF"), CHAR_LENGTH("ABCDEF"),
BIT_LENGTH("가나다라마바"), LENGTH("가나다라마바"), CHAR_LENGTH("가나다라마바");
-- LENGTH(STR) 은 차지하는 BYTE  값을 출력한다.

-- 문자 찾기(날짜도 문자열함수 사용)
-- 오라클 + MySQL ==> 함수 + MariaDB
SELECT ELT(2, '일이','둘','셋'); -- JAVA 인덱스번호 0번부터 시작
SELECT FLIELD('일이','일이','둘','셋');
SELECT FIND_IN_SET('일이','일이,삼사,오육');
SELECT INSTR('일이삼사오육', '삼');
SELECT LOCATE('삼', '일이삼사오육');
SELECT SUBSTRING('김상형의 SQL정복', 5, 3); -- 공백,S,Q 라서 SQ출력됨
SELECT SUBSTR('김상형의 SQL정복', 5, 3); -- SUBSTRING() = SUBSTR()
SELECT NOW();
SELECT SUBSTR

SELECT HIRE_DATE 입사시각, SUBSTR(HIRE_DATE, 1, 4) 입사년도, SUBSTR(HIRE_DATE, 6, 2) 입사월 FROM employees;

-- 클라이언트 압호입력시 DB 테이블 저장
SET @PW = "ABC가나다123";
SELECT @PW;
SELECT @PW, INSERT(@PW, 2, 4, "****");
SELECT REPEAT("*",CHAR_LENGTH(@PW));

-- @PW 변수의 모든 값을 *로 조회
SELECT @PW, INSERT(@PW, 1, 9, REPEAT("*",CHAR_LENGTH(@PW)));

SELECT @PW, INSERT(@PW, 1, CHAR_LENGTH(@PW), REPEAT("*",CHAR_LENGTH(@PW)));

SELECT @PW, INSERT(@PW, 2, CHAR_LENGTH(@PW) - 1, REPEAT("*",CHAR_LENGTH(@PW)));

SELECT "ABCDEF", LEFT("ABCDEF",3), RIGHT("ABCDEF",3);

SELECT "mArIa DATABase", UPPER("mArIa DATABase"), LOWER("mArIa DATABase");

-- JAVA 키보드 입력 "Maria".toUpperCase() --> DB upper("mArIa")
-- pad : 다른 문자열 채운다
SELECT 'abc', LPAD('abc', 10, "#"), RPAD('abc',10, '#');

SELECT 'abc', LPAD('abc', 10, " "), RPAD('abc',10, ' ');

SELECT FIRST_NAME, LPAD(FIRST_NAME, 20, "-") FROM employees;
-- LPAD 오른쪽 정렬효과! 왼쪽에 집어넣으니까
-- RPAD 왼쪽 정렬효과! 마찬가지의 이유
DESC employees; 


-- 성 - LAST_NAME, 이름 - FIRST_NAME
SELECT CONCAT("성 - ", LAST_NAME, ", 이름 - ", FIRST_NAME) FROM employees;

"성 - " + LAST_NAME + ", 이름 - " + FIRST_NAME
"성 - " + LAST_NAME +  || ", 이름 - " + FIRST_NAME
CONCAT("성 - ", LAST_NAME, ", 이름 - ", FIRST_NAME);

SELECT FIRST_NAME 이름, IF(COMMISSION_PCT IS NULL, "못받는다", "받는다") 보너스유무
FROM employees;

-- 급여정보.. 연말보너스 지급
SELECT FIRST_NAME 이름, SALARY 급여,
CASE
WHEN SALARY >= 20000 THEN SALARY + 5000
WHEN SALARY >= 20000 THEN SALARY + 5000
WHEN SALARY >= 20000 THEN SALARY + 5000
ELSE SALARY + 30000
END 연말보너스
FROM employees;

DESC employees ;
SELECT * FROM employees;
-- 2002년 전까지의 입사자 30000 / 2005년 전까지의 입사자 20000
-- 나머지 10000
SELECT HIRE_DATE, YEAR(HIRE_DATE), MONTH(HIRE_DATE), DAY(HIRE_DATE)
FROM employees;
SELECT FIRST_NAME 이름, SALARY 급여, HIRE_DATE 입사일,
CASE
WHEN YEAR(HIRE_DATE) < 2002 THEN SALARY+ 30000
WHEN YEAR(HIRE_DATE) < 2005 THEN SALARY+ 20000
ELSE SALARY + 10000
END 연말보너스
FROM employees;

SELECT FIRST_NAME 이름, SALARY 급여, HIRE_DATE 입사일,
CASE SUBSTR(HIRE_DATE, 1, 4)
WHEN '2001' THEN SALARY + 30000
WHEN '2002' THEN SALARY + 30000
WHEN '2003' THEN SALARY + 20000
WHEN '2004' THEN SALARY + 20000
WHEN '2005' THEN SALARY + 20000
ELSE SALARY + 10000
END 연말보너스
FROM employees;

SELECT FIRST_NAME 이름, SALARY 급여, HIRE_DATE 입사일,
CASE
WHEN SUBSTR(HIRE_DATE, 1, 4) IN('2001', '2002') THEN SALARY + 30000
WHEN SUBSTR(HIRE_DATE, 1, 4) IN('2003', '2004', '2005') THEN SALARY + 20000
ELSE SALARY + 10000
END 연말보너스
FROM employees;

-- MariaDB에는 DECODE함수 없다.

-- 날짜함수
SELECT CURDATE(), CURRENT_TIMESTAMP(), CURRENT_DATE, CURTIME(), NOW(),SYSDATE();

-- CAST CONVERT FORMAT + DATE_FORMAT (사용하기 쉽다)
-- in java : 'yyyy-MM-dd HH:mm:ss'
SELECT NOW(), DATE_FORMAT(NOW(), '%Y/%m/%d'), DATE_FORMAT(NOW(), '%Y-%m-%d');
SELECT NOW(), DATE_FORMAT(NOW(), '%y/%M/%D'), DATE_FORMAT(NOW(), '%Y-%m-%d');
SELECT NOW(), DATE_FORMAT(NOW(), '%y/%c/%e');


/* in SQL
%Y, %y - 4/2자리 년도
%m, %M, %c - 2자리 / 영문월이름 / 1,2자리 월표기
%D, %d, %e - 서수식표기 / 2 / 1,2자리 일
%W - 영문요일
%a - 영문3글자요일

%H, %h - 24/12 시간
%i - 분
%s - 초
*/

-- 2006년 입사자 급여 조회
SELECT HIRE_DATE, SALARY FROM employees 
WHERE HIRE_DATE >= '2006-01-01 00:00:00'
AND HIRE_DATE < '2007-01-01 00:00:00'
;

SELECT HIRE_DATE, SALARY FROM employees WHERE HIRE_DATE LIKE '2006%';
SELECT HIRE_DATE, SALARY FROM employees WHERE SUBSTR(HIRE_DATE,1,4) = '2006';
SELECT HIRE_DATE, SALARY FROM employees WHERE INSTR(HIRE_DATE, '2006') = 1;
SELECT HIRE_DATE, SALARY FROM employees WHERE DATE_FORMAT(HIRE_DATE, '%Y') = '2006';
SELECT SUBSTR(HIRE_DATE, 1, 4), DATE_FORMAT(HIRE_DATE, '%Y'), SALARY FROM employees;

-- 연도 추출함수 YEAR()

SELECT UPPER(FIRST_NAME) 사원이름, HIRE_DATE 입사일,
CASE
WHEN WEEKDAY(HIRE_DATE) = 0 THEN '일요일'
WHEN WEEKDAY(HIRE_DATE) = 1 THEN '월요일'
WHEN WEEKDAY(HIRE_DATE) = 2 THEN '화요일'
WHEN WEEKDAY(HIRE_DATE) = 3 THEN '수요일'
WHEN WEEKDAY(HIRE_DATE) = 4 THEN '목요일'
WHEN WEEKDAY(HIRE_DATE) = 5 THEN '금요일'
ELSE '토요일'
END 입사요일
FROM employees
;

SELECT UPPER(FIRST_NAME) 사원이름, HIRE_DATE 입사일,
CASE WEEKDAY(HIRE_DATE)
WHEN 0 THEN '일요일'
WHEN 1 THEN '월요일'
WHEN 2 THEN '화요일'
WHEN 3 THEN '수요일'
WHEN 4 THEN '목요일'
WHEN 5 THEN '금요일'
ELSE '토요일'
END 입사요일
FROM employees
;

-- 두 날짜 사이의 계산
SELECT CURDATE() 오늘날짜,
SUBDATE(CURDATE(),INTERVAL 1 DAY) 어제날짜,
ADDDATE(CURDATE(),INTERVAL 1 DAY) 내일날짜,
ADDDATE(CURDATE(),INTERVAL 1 MONTH) 한달후날짜,
ADDDATE(CURDATE(),INTERVAL 1 YEAR) 1년후날짜; -- 일반적으로 SQL 문법상 별칭으로 숫자를 맨앞에 쓰려면 ""로 묶어줘야함.

-- 입사한 지 얼마나 경과했는지 경과일수 계산
SELECT FIRST_NAME, DATEDIFF(NOW(),HIRE_DATE) 경과일수, 
TRUNCATE(DATEDIFF(NOW(),HIRE_DATE)/7,0)경과주수, 
TRUNCATE(DATEDIFF(NOW(),HIRE_DATE)/365,0)경과년수,
PERIOD_DIFF(DATE_FORMAT(NOW(), "%Y%m"),DATE_FORMAT(HIRE_DATE, "%Y%m")) 경과개월수
-- PERIOD_DIFF('202212','202112') 경과개월수
-- PERIOD_DIFF(P1,P2) : P1과 P2에는 구분자나 특수기호 없이 정수만 들어가야 나온다.
-- DATEDIFF(최근날짜, 이전날짜)
FROM employees;




