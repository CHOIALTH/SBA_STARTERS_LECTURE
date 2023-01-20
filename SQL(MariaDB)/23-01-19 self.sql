SHOW DATABASES;  
USE mysql;       
select host, user from USER;
show grants for 'user'@'localhost';
                 
CREATE USER 'jdbc'@'%' IDENTIFIED BY 'jdbc';
SELECT * FROM USER;
                 
GRANT ALL PRIVILEGES ON *.* TO 'jdbc'@'%';
                 
