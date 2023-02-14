package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //내가 설정클래스파일
public class MyWebConfig implements WebMvcConfigurer {
	//for window
	//static final public String savePath = "c:/upload/";
	
	//for linux
	static final public String savePath = "/usr/upload/";
//수정
//	<resources mapping="/upload/**" location="file:///c:/upload/" />

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//for window
		//registry.addResourceHandler("/upload/**").
		//addResourceLocations("file:///c:/upload/");
		//for linux
		// putty로 서버 접속후 
		// mkdir /usr/upload 실행후 
		registry.addResourceHandler("/upload/**").
		addResourceLocations("file:/usr/upload/");
	}
	
}
