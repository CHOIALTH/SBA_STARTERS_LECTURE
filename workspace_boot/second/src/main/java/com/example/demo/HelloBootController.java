package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBootController {

	@Autowired
	HelloDTO dto;
	
	@RequestMapping("/helloboot")
	public ModelAndView helloboot() {
		ModelAndView mv= new ModelAndView();
		dto.setModel("부트 실행 결과입니다.");
		mv.addObject("dto", dto);
		mv.setViewName("helloboot");// src/main/webapp/WEB-INF/views/?.jsp
		return mv;
	}
	
	@GetMapping("/hellobootajax")
	@ResponseBody 
	public  String helloajax() {
		return "{\"result\":\"부트에서 ajax 호출결과 응답 \"}";
	}
	
}






