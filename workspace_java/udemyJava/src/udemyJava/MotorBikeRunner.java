package udemyJava;

public class MotorBikeRunner {
	
	public static void main(String[] args) {
		MotorBike ducati = new MotorBike();
		MotorBike honda = new MotorBike();
		// ducatti, honda : instance
		
		ducati.start(); 
		honda.start();

		ducati.stop();
		honda.stop();
		// start, stop : method
		ducati.setSpeed(100);
		honda.setSpeed(97); // 이상 각 오토바이의 상태(state)
		
		ducati.setSpeed(20);
		honda.setSpeed(0);
		// 교통체증...등으로 객체 상태의 변화
		
		System.out.println(ducati.getSpeed());
		System.out.println(honda.getSpeed());
	}

} // class
