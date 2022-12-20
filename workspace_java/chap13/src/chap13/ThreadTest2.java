package chap13;

class TimeThread extends Thread{

	@Override
	public void run() {
		for(int i = 1; i <= 30; i++ ) {
			System.out.print("|");
		} // for end
		System.out.println("소요시간2(1/1000초) = " + (System.currentTimeMillis() - ThreadTest2.startTime));
	}
}


public class ThreadTest2 {
	static long startTime = 0; // 이렇게만 작성시 타 클래스에서 사용불가
	//long startTime = 0; // 이렇게만 작성시 타 클래스에서 사용불가
	public static void main(String[] args) {
		TimeThread tt = new TimeThread();
		tt.start();
		// 현재시각. 1/1000초
		long startTime = System.currentTimeMillis();
		for(int i = 1; i <= 30; i++) {
			System.out.print("-");
		} // for end
		System.out.println("소요시간1(1/1000초) = " + (System.currentTimeMillis() - startTime));	
	
	}
}

