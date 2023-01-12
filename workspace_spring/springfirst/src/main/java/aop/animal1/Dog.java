package aop.animal1;

public class Dog implements Animal{

	@Override
	public String lunch() {
		String food = "사료";
		System.out.println(food + " 먹었습니다");
		return food;

	}
	
}
