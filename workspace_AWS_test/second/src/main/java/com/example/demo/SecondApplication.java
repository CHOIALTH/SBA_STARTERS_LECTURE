package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //내가 설정클래스파일+스프링시작tomcat시작
@ComponentScan
@ComponentScan(basePackages = {"upload", "board.spring.mybatis"})
@ComponentScan(basePackages ="spring.mybatis")
@ComponentScan(basePackages = "websocket")
@ComponentScan(basePackages = "dbsecure")

@MapperScan(basePackages = {"spring.mybatis", "board.spring.mybatis"})

public class SecondApplication {
	public static void main(String[] args) {
		User user = new User();
		SpringApplication.run(SecondApplication.class, args);
	}

}
