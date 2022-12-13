package test;

class Bird{
	//Duck, Sparrow 공통 특성 변수 + 메서드
	String name;
	String setName;
	int lgs; //다리의 개수
	int length; //몸의 길이
	
	String setName(String x) {
		String setName = x;
		return setName;
	}
	void print(String setName){
		System.out.printf("%s의 이름은 %s 입니다",name,setName);
	}
	void sing(String setName) {
		if(setName == "꽥꽥이") {
			System.out.printf("%s(%s)가 소리내어 웁니다.", name, setName);
		}
	}	
	
	void fly(String name) {
		//System.out.printf("%s(%s)는 %s);
	}
	
	
}

class Duck extends Bird{
	String name = "오리";
	@Override
	String setName(String x) {
		return super.setName("꽥꽥이");
	}
}

class Sparrow extends Bird{
	String name = "참새";
	@Override
	String setName(String name, String x) {
		System.out.printf("참새의 이름은 %s 입니다", x);
		return super.setName(x);
	}
}

public class PlayBird {

	public static void main(String[] args) {
		Duck d = new Duck();
		d.setName("꽥꽥`");
		//d.fly();
		//d.sing();
		//d.swim();
		//d.print();
		Sparrow s = new Sparrow();
		//s.fly();
		//s.sing();
		//s.makeFriend();
		//s.print();
	}

}
