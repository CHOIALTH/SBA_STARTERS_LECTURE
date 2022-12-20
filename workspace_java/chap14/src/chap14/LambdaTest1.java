package chap14;

// 1.
class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Runnable구현자식클래스 실행");
	}
	
}



public class LambdaTest1 {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
		// 2.
		class MyInnerThread implements Runnable{
			@Override
			public void run() {
				System.out.println("Runnable구현내부클래스 실행");
			}
		}// MyInnerThread
		Thread t2 = new Thread(new MyInnerThread());
		t2.start();
		// 3. 무명클래스
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Runnable구현익명클래스 실행");
			}
		});
		t3.start();
		
		// 람다식 - 함수형 인터페이스 (추상메서드1개만)
		Runnable r4 = ()->{
			// JS 화살표함수 : => / java 람다식 형식 : ->
			System.out.println("람다식 실행");
		};
		Thread t4 = new Thread(r4);
		t4.start();
	}

}
