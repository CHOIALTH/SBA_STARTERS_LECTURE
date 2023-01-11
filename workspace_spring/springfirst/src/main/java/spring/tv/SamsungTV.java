package spring.tv;
public class SamsungTV implements TV{
	SamsungTV(){
		System.out.println("SamsungTV 생성자 호출됩니다.");
	}
	public void powerOn() {
		System.out.println("SamsungTV: 전원 켜다.");
	}
	
	public void powerOff(int v) {
		System.out.println("SamsungTV: 전원 끄다.");
	}
	
	public void soundUp(int v) {
		System.out.println("SamsungTV:" + v + " 만큼 볼륨 높이다.");
	}
	
	public void soundDown(int v) {
		System.out.println("SamsungTV:" + v + " 만큼 볼륨 낮추다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV:전원끄다.");
	}
}