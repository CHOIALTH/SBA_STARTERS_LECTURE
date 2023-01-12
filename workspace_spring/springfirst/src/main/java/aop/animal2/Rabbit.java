package aop.animal2;

import org.springframework.stereotype.Component;

@Component
public class Rabbit implements Animal{

	@Override
	public String lunch() {
		String food = "당근";
		System.out.println(food + " 먹었습니다");
		return food;

	}
	
}
