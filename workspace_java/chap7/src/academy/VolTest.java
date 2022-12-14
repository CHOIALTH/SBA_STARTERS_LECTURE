package academy;

interface Volume {
	/* public */ void volumeUp(int vol);
	/* public */ void volumeDown(int vol);
	static void print1(String name) {
		System.out.println(name + "클래스가 볼륨업 수행중입니다");
	}
	static void print2(String name) {
		System.out.println(name + "클래스가 볼륨다운 수행중입니다");
	}
	default void print3() {
		System.out.println("뒤늦게 메서드 추가 = 자식클래스 오버라이딩 선택적");
	}
}

class Speaker implements Volume{
	//Volume interface를 상속받는다
	int VolLevel;
	Speaker(int vol){
		/* this. */VolLevel = vol;
		System.out.println("현재 Speaker의 볼륨 = " + VolLevel);

	}
	//-100~100
	public void volumeUp(int vol) {
		Volume.print1("Speaker");
		VolLevel += vol;
		if(VolLevel > 100) {
			VolLevel = 100;
		}
		System.out.println("현재 Speaker의 볼륨 = " + VolLevel);
	}

	public void volumeDown(int vol) {
		Volume.print2("Speaker");
		VolLevel -= vol;
		if(VolLevel < -100) {
			VolLevel = -100;
		}
		System.out.println("현재 Speaker의 볼륨 = " + VolLevel);
	}
	public void print3() {
		System.out.println("Speaker클래스에서 오버라이딩합니다");
	}
	
	
}

class Radio implements Volume{
	int VolLevel;
	Radio(int vol){
		/* this. */VolLevel = vol;
		System.out.println("현재 Radio의 볼륨 = " + VolLevel);

	}
	//
	public void volumeUp(int vol) {
		Volume.print1("Radio");
		VolLevel += vol;
		System.out.println("현재 Radio의 볼륨 = " + VolLevel);
	}

	public void volumeDown(int vol) {
		Volume.print2("Radio");
		VolLevel -= vol;
		System.out.println("현재 Radio의 볼륨 = " + VolLevel);
	}

}

class TV implements Volume{
	int VolLevel;
	TV(int vol){
		/* this. */VolLevel = vol;
		System.out.println("현재 TV의 볼륨 = " + VolLevel);

	}
	//
	public void volumeUp(int vol) {
		Volume.print1("TV");
		VolLevel += vol;
		System.out.println("현재 TV의 볼륨 = " + VolLevel);
	}

	public void volumeDown(int vol) {
		Volume.print2("TV");
		VolLevel -= vol;
		if(VolLevel < 0) {
			VolLevel = 0;
		}
		System.out.println("현재 TV의 볼륨 = " + VolLevel);
	}
}

public class VolTest {

	public static void main(String[] args) {
		Volume v[ ] = new Volume[3];
		v[0] = new Speaker(50);
		v[1] = new TV(40);
		v[2] = new Radio(30);
		for(int i = 0; i < v.length; i++){
		 v[i].volumeUp(200);
		 v[i].volumeDown(300);
		 v[i].print3();
		}
	}
}
