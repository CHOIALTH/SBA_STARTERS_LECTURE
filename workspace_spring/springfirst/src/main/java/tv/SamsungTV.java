package tv;
public class SamsungTV {
	void powerOn() {
		System.out.println("SamsungTV:전원켜다.");
	}
	
	void powerOff(int v) {
		System.out.println("SamsungTV:전원끄다.");
	}
	
	void volumeUp(int v) {
		System.out.println("SamsungTV:" + v + " 만큼 볼륨 높이다.");
	}
	
	void volumeDown(int v) {
		System.out.println("SamsungTV:" + v + " 만큼 볼륨 낮추다.");
	}
	void powerOff() {
		System.out.println("SamsungTV:전원끄다.");
	}
}