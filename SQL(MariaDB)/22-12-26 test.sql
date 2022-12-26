-- 2022-12-26 실습
-- int char datetime

USE empdb;
CREATE TABLE menu(
p_code INT(5) PRIMARY KEY,
p_name CHAR(100) UNIQUE,
price INT(5) CHECK(price >= 100 AND price <= 10000),
inven INT(3) CHECK(inven >= 0),
spec TEXT(4000),
-- char(4000)자리 
imgfile CHAR(50)
);
-- DROP TABLE menu;
ALTER TABLE menu MODIFY p_code INT(5) AUTO_INCREMENT;
DESC menu;
SELECT * FROM menu;

CREATE TABLE customer(
user_id CHAR(30) PRIMARY KEY,
user_name CHAR(30) NOT NULL,
email CHAR(30) UNIQUE,
phone CHAR(11) CHECK(phone LIKE("010%")),
signup DATETIME,
balance INT(7) CHECK(balance >= 0)
);
DESC customer;
SELECT * FROM customer;
-- ALTER TABLE customer MODIFY ordercode INT(5) AUTO_INCREMENT;

CREATE TABLE orders(
ordercode INT(5) PRIMARY KEY,
user_id CHAR(30) NOT NULL,
p_code INT(5),
qty INT(3) CHECK(qty >= 0 AND qty <= 100),
ordertime DATETIME,
CONSTRAINT FOREIGN KEY(user_id) REFERENCES customer(user_id),
CONSTRAINT FOREIGN KEY(p_code) REFERENCES menu(p_code)
);
DESC orders;
SELECT * FROM orders;
ALTER TABLE orders MODIFY ordercode INT(5) AUTO_INCREMENT;
DROP TABLE orders;

-- 메뉴:menu테이블레코드들
INSERT INTO menu(p_name, price, inven, spec, imgfile) VALUES ('아메리카노', 2000, 100,'핫,아이스 선택가능:추가요금없음', 'americano.jpg');
INSERT INTO menu(p_name, price, inven, spec, imgfile) VALUES ('카페라떼', 3000, 100 , '두유 변경가능:추가요금없음','latte.jpg');
INSERT INTO menu(p_name, price, inven, spec, imgfile) VALUES ('딸기바나나쥬스', 3000, 50 ,'딸기싱싱','ddalba.jpg');
INSERT INTO menu(p_name, price, inven, spec, imgfile) VALUES ('치즈케익', 5000, 10, '사이즈10*10','cheesecake.jpg');
INSERT INTO menu(p_name, price, inven, spec, imgfile) VALUES ('클럽샌드위치', 4500, 10, '치킨,베이컨선택가능:4조각','sandwich.jpg'
);

-- 고객 : customer테이블 레코드들
INSERT INTO customer(user_id, user_name, email, phone, signup, balance) VALUES('jung1', '유정은', 'jung1@kitri.com', '0102223333', '2022-12-26', 30000
);
INSERT INTO customer(user_id, user_name, email, phone, signup, balance) VALUES('inchul1', '신인철', 'in1@bit.com' ,'0103335677', '2022-11-26' ,40000
);
INSERT INTO customer(user_id, user_name, email, phone, signup, balance) VALUES('hee1', '황희정', 'heejung1@multi.com', '0102224444', '2021-12-26', 50000
);

-- 주문
SELECT p_name, price, spec FROM menu;

SELECT user_id, balance FROM customer WHERE user_name = "황희정";

INSERT INTO orders (ordercode, user_id, p_code, ordertime, qty) 

VALUES (1, (SELECT user_id FROM customer WHERE user_name = "황희정" ), (SELECT p_code FROM menu WHERE p_name = '클럽샌드위치'), now(), 2);

UPDATE menu SET inven = inven - (SELECT qty FROM orders) WHERE p_code = 5;

UPDATE customer SET balance = balance - (SELECT price FROM menu WHERE p_code = (SELECT p_code FROM orders WHERE user_id = "hee1") ) * (SELECT qty FROM orders WHERE user_id = "hee1");

SELECT user_id AS "고객아이디", 
(SELECT user_name FROM customer WHERE user_id = (SELECT user_id FROM orders WHERE ordercode = 1)) AS "고객이름",
(SELECT p_name FROM menu WHERE p_code = (SELECT p_code FROM orders WHERE user_id = "hee1") ) AS "제품명",
qty AS "구매수량",
(SELECT price FROM menu WHERE p_code = (SELECT p_code FROM orders WHERE user_id = "hee1") ) * (SELECT qty FROM orders WHERE user_id = "hee1") AS "결재액", 
(SELECT balance FROM customer WHERE user_id = "hee1" ) AS "잔액" FROM orders;
