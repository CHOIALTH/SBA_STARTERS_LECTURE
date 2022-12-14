package inter;

class StudentWorker implements Student,Worker{
	
	@Override
	public void work() {
	System.out.println("학교일하다");
	}
		
	@Override
	public void study() {
	System.out.println();
	}
	@Override
	public void lunch() {
		System.out.println("학생식당이나 교직원식당에서 점심먹다");
	}
	//생성자 변수 메서드 추라 가능
}

public class InterfaceTest {

	public static void main(String[] args) {
		StudentWorker sw = new StudentWorker();
		0.

	}

}
