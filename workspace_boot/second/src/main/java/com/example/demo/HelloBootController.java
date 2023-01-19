package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloBootController {
	@Autowired
	HelloDTO dto;
	
	@RequestMapping("/helloboot")
	public ModelAndView helloboot() {
		ModelAndView mv = new ModelAndView();
		dto.setModel("부트실행결과입니다");
		mv.addObject("dto", dto);
		mv.setViewName("helloboot"); // src/main/WEB-INF/views/?.jsp
		return mv;
		
	}
	@GetMapping("hellobootajax")
	public String helloajax() {
		return "{\"result\" : \"부트에서 ajax 호출결과 응답\"}";
	}
}
