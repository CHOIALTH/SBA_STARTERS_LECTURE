package spring.tv;

public class LgTV implements TV {
	LgTV(){
		System.out.println("LgTV 생성자 호출됩니다.");
	}
	public void powerOn() {
		System.out.println("LgTV: 전원 켜다");
	}
	public void powerOff() {
		System.out.println("LgTV: 전원 끄다");
	}
	public void soundUp(int v) {
		System.out.println("LgTV:" + v + " 만큼 볼륨 높이다.");
	}
	
	public void soundDown(int v) {
		System.out.println("LgTV:" + v + " 만큼 볼륨 낮추다.");
	}
	
	
}
