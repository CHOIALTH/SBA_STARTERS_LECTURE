package test;

public class PlayBird {
public static void main(String[] args) {
	Duck d = new Duck("오리(꽥꽥이)", 2);
	Sparrow s = new Sparrow("참새(짹짹)");
	d.setName("오리(꽥꽥이)");
	d.fly();
	d.sing();
	d.swim();
	d.print();
	s.setName("참새(짹짹)");
	s.fly();
	s.sing();
	s.makeFriend();
	s.print();

	}
}
class Bird {//Duck, Sparrow 클래스 반드시 fly 구현 공통 
	String name;
	int legs;
	double length;
	Bird(String name){
		this.name = name;
	}
	public void fly(){
		System.out.println(name + " 가 날아다닙니다.");
	}
	public void sing(){
		System.out.println(name + " 가 소리내어 웁니다.");
	}
	public void setName(String name){
		this.name = name;
	}
	public void print(){
		String subnames[] = name.split("[()]");
		System.out.println
		(subnames[0] + "의 이름은 "  + subnames[1] + "입니다");
	}
}
class Duck extends Bird {
	//물갈퀴 변수
	int web = 2;
	public Duck(String name, int web) {
		super(name);
		this.web = web;
	}
	public void swim(){		
		System.out.println
		(name + " 가 " + web + " 개의 물갈퀴로 수영합니다.");}
	public void fly() {
		System.out.println(name + " 가 날지 않습니다.");
	}
}

class Sparrow extends Bird {
	
	public Sparrow(String name) {
		super(name);
	}
	String friend ;
	void makeFriend() {
		friend = "허수아비";
		System.out.println("참새의 친구는 " + friend + " 입니다");
	}
	public void live(){}
	public void fly(){
		System.out.println
		(name + "는 날 수 있습니다.");
	}
}
