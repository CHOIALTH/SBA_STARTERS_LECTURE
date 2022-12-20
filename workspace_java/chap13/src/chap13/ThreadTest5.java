package chap13;

class JoinThread extends Thread{
	int i = 1; 
	public void run() {
		i = 10;
		System.out.println("run메소드내부 = " + i);
	}
}

public class ThreadTest5 {

	public static void main(String[] args) {
		JoinThread t = new JoinThread();
		t.start(); // t: 실행가능상태. main: 실행상태
		try {
			t.join(); // t: 실행상태. main: 실행가능상태
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메서드 내부 = " + t.i); // 10
		System.out.println("main 종료");
	}

}
