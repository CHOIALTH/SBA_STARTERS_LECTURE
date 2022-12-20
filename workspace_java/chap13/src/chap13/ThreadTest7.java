package chap13;

import java.awt.Point;

class Buffer{
	int value;
	boolean available = false;
	// available true value 읽기 가능한 상태
	// available false value 저장 가능한 상태
	synchronized int getValue() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // while end		
		System.out.println("조회 : " + value);
		available = false;
		notify();
		return value;
	}
	synchronized void setValue(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // while end
		this.value = value;
		System.out.println("저장 : " + value);
	}
}

class Producer extends Thread{
	Buffer buf;
	Producer(Buffer buf){
		this.buf = buf;
	}
	public void run() {
		for(int i = 1; i<=10; i++) {
			buf.setValue(i);
		}
	}
}
class Consumer extends Thread{
	Buffer buf;
	Consumer(Buffer buf){
		this.buf = buf;
	}
}

public class ThreadTest7 {

	public static void main(String[] args) {
		Buffer buf = new Buffer();
		Producer p = new Producer(buf);
		Consumer c = new Consumer(buf);
	}

}
