package udemyJava;

class Planet{
	void revolve() {
		System.out.println("공전중입니다.");
	} // method (특정 class의 사례에 행할 수 있는 행동으로 보자)
} // class

class Country{
	void comingSoon() {
		System.out.println("Coming Soon");
	}
}

public class Lec230102 {

	public static void main(String[] args) {
		// 메인메서드 형태는
		// public static void main(String[] args) {} 로 고정됨
		// 이 형태 중 어느 하나 다르게 해도 오류를 출력함
		
		Planet earth = new Planet();
		Planet venus = new Planet();
		earth.revolve();
		venus.revolve();
		Country korea = new Country();
		Country usa = new Country();
		korea.comingSoon();
		usa.comingSoon();
	}

}
   