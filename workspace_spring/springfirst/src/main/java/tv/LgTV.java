package tv;

public class LgTV implements TV {
	public void powerOn() {
		System.out.println("LgTV 전원 켜다");
	}
	public void powerOff() {
		System.out.println("LgTV 전원 끄다");
	}
	public void soundUp(int v) {
		System.out.printf("%d만큼 소리를 키우다\n", v);
	}
	public void soundDown(int v) {
		System.out.printf("%d만큼 소리를 줄이다\n", v);
	}
	
	
}
