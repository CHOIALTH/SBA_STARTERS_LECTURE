package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // 내가 설정클래스파일. (com.example.demo만 스캔할땐 이 어노테이션으로 충분)
//@ComponentScan // basePackages = "com.example.demo"
@ComponentScan(basePackages = "upload")
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
