package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //내가 설정클래스파일+스프링시작tomcat시작
@ComponentScan
@ComponentScan(basePackages = "upload")
@ComponentScan(basePackages ="spring.mybatis")
@MapperScan(basePackages = "spring.mybatis")
@ComponentScan(basePackages = "websocket")
public class SecondApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
