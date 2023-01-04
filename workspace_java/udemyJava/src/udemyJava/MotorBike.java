package udemyJava;

public class MotorBike {
	// int speed
	private int speed; // speed : 인스턴스 변수 -> 개체로부터 참조될 수 있음
	// 변수 앞에 private 붙으면, 다른 클래스에서 사용 시 ~.변수명 is not visible 이라는 오류 발생
	
	void setSpeed(int speed) { // 여기서 speed 지역변수 (local variable)
		this.speed = speed;
		System.out.println("스피드 : " + speed);
	}
	int getSpeed() {
		return speed;
		// return this.speed;
	}
	
	void start() {
		System.out.println("Bike Started");
	}
	void stop () {
		System.out.println("Bike Stopped");
	}

}
