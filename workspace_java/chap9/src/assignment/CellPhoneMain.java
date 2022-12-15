package assignment;

public class CellPhoneMain {

	public static void main(String[] args) {
		CellPhone myPhone = new CellPhone("GALAXY-7");
		// charge, call 메소드 호출 포함하여 try-catch 블록 정의
		// throws 하고 있는 예외 처리한다.
		// 각 예외 발생시 어떤 메소드에서 어떤 원인으로 발생했는지 출력한다
		myPhone.charge( 20 ); // 20분간 충전을 한다.
		myPhone.printBattery();
		myPhone.call( 300 ); // 300분간 통화를 한다.
		myPhone.printBattery();
		myPhone.charge( 50 ); // 50분간 충전을 한다.
		myPhone.printBattery();
		myPhone.call( 40 ); // 40분간 통화를 한다.
		myPhone.printBattery();
		myPhone.call( -20 ); // 통화시간입력오류
		CellPhone yourPhone = new CellPhone("galaxy-7");
		
		if( myPhone.isSame(yourPhone) ) {
			System.out.println("동일 모델입니다.\n");
		} 
		else {
			System.out.println("다른 모델입니다.\n");
		} 
	}
}

class CellPhone {
	String model; // 핸드폰 모델 번호
	double battery; // 남은 배터리 양
	
	CellPhone(String model){
		this.model = model;
	} 
	void call(int time) throws IllegalArgumentException { // 메서드1
		IllegalArgumentException il = new IllegalArgumentException("통화시간입력오류\n");
		if(time > 0) {
			battery = battery - time * 0.5;
			System.out.println("통화 시간 : " + time + "분\n");
			if(battery <= 0) {
				battery = 0;
				//System.out.println("통화 시간 : " + time + "분\n");
			}
		}
		else try {
			throw il;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void charge(int time) throws IllegalArgumentException { // 메서드2 
		// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리 양을 증가시킨다.
		// 선언부에 IllegalArgumentException 전달 표현을 추가한다
		// 충전되는 배터리 양 = 충전시간(분) * 3
		// 배터리 양은 100까지만 증가한다.
		// 충전 시간(분)이 0보다 작은 경우에는 배터리 양은 변화없고
		// IllegalArgumentException("충전시간입력오류”) 발생시킨다
		//IllegalArgumentException il = new IllegalArgumentException("통화시간입력오류\n");
		 if (time < 0) {
	         throw new IllegalArgumentException("충전시간입력오류\n");
	      } else {
	         System.out.println("충전 시간 : " + time + "분\n");
	         battery = battery + time * 3;
	         if (battery > 100)
	            battery = 100.0;
	      }
	}
	void printBattery() { // 메서드3 
		System.out.println("남은 배터리 양 : " + battery + "\n");
	}
	boolean isSame(CellPhone other) { // 메서드4 
		// CellPhone 타입의 객체를 입력받고, 입력받은 객체의
		// 모델 번호가 같은 경우에 true를 리턴한다.
		if ((other instanceof CellPhone)) {
			return true;
		}
		else return false;
	}
}