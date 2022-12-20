package chap13;

import javax.swing.JOptionPane;

class NumberThread extends Thread{
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 쉰다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for end
	}
	
}

public class ThreadTest3 {

	public static void main(String[] args) {
		NumberThread nt = new NumberThread(); // NumberThread 객체 생성
		nt.start();
		String input = JOptionPane.showInputDialog("값 입력해 보세요");
		System.out.println("입력값 = " + input);
		
		/*
		 * for(int i = 1; i <= 10; i++) { System.out.println(i); try {
		 * Thread.sleep(1000); // 1초 쉰다 } catch (InterruptedException e) {
		 * e.printStackTrace(); } } // for end
		 */	}

}
