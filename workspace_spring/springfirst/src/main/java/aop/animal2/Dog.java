package aop.animal2;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{

	@Override
	public String lunch() {
		String food = "사료";
		System.out.println(food + " 먹었습니다");
		return food;

	}
	
}
