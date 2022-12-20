package chap13;

class Data{int  value;}
class DataThread1 extends Data{}
class DataThread2 extends Data{}


public class ThreadTest6 {

	public static void main(String[] args) {
		Data data = new Data();
		DataThread1 dt1 = new DataThread1();
		DataThread2 dt2 = new DataThread2();
	}

}
