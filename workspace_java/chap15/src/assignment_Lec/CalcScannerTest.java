package assignment_Lec;

import java.util.ArrayList;
import java.util.Scanner;

class Calculator{
	int su1,su2;
	String op;
	public Calculator(int su1, int su2, String op) {
		//super();
		this.su1 = su1;
		this.su2 = su2;
		this.op = op;	
	}
	@Override
	public String toString() {
		int result = 0;
		if(op.equals("+")) {
			result = su1 + su2;
		}
		else if(op.equals("-")) {
			result = su1 - su2;
		}
		else if(op.equals("*")) {
			result = su1 * su2;
		}
		else if(op.equals("/")) {
			result = su1 / su2;
		}
		
		return su1 + op + su2 + " = " + result;
	}
	
	
}

public class CalcScannerTest {

	public static void main(String[] args) {
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("덧셈"); // ArrayList상 0번 원소
		menu.add("뺄셈"); // ArrayList상 1번 원소
		menu.add("곱셈"); // ArrayList상 2번 원소
		menu.add("나눗셈");// ArrayList상 3번 원소
		menu.add("프로그램 종료!");// ArrayList상 4번 원소
		System.out.println("계산기를 시작합니다.\n종료하려면 5 또는 q를 입력하세요\n메뉴");
		for(int i = 0; i < menu.size(); i++) {
			System.out.println((i+1) + ". " + menu.get(i));
		}
		System.out.println("선택번호 입력 : ");
		
		while(true) {
		Scanner key = new Scanner(System.in);
		// key에 키보드에 입력된 값을 담는다.
		//int num = key.nextInt();
		// key.nextInt는 정수값만 읽을 수 있다.
		String num = key.next();
		// key.next()는 정수/문자 다 읽음
		if((num.equals("5"))||(num.equals("q"))||(num.equals("quit"))||(num.equals("exit")) ) {
			System.out.println("프로그램 종료!");
			System.exit(0);
			// 프로그램 종료 
			// return; // 현재 메서드 종료
		}
		else {
			System.out.println(menu.get(Integer.parseInt(num) - 1) + "할 데이터1 입력 : ");
			int first = key.nextInt();
			System.out.println(menu.get(Integer.parseInt(num) - 1) + "할 데이터2 입력 : ");
			int second = key.nextInt();
			String op = null;
			if(num.equals("1")) {
				op = " + ";
			}
			else if(num.equals("2")) {
				op = " - ";
			}
			else if(num.equals("3")) {
				op = " * ";
			}
			else if(num.equals("4")) {
				op = " / ";
			}
			Calculator calc = new Calculator(first, second, op);
			System.out.println("결과 : " + calc);
		}
		}
	}

}
