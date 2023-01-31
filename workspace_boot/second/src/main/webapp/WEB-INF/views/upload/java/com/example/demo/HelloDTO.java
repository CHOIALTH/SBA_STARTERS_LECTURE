package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class HelloDTO {
	String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
