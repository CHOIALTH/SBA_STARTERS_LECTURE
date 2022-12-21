package assignment;

import java.io.IOException;
import java.util.Scanner;




public class Calculator {
		int data1, data2;
	public static void main(String[] args) throws IOException {
		System.out.println("계산기를시작합니다.\n종료하려면 q를 입력하세요.\n 메뉴\n1. 덧셈\n2. 뺄셈\n3. 곱셈\n4. 나눗셈\n5. 프로그램 종료");
		//InputStreamReader isr = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(isr);
		Scanner key = new Scanner(System.in);
		while(key.hasNextInt()) {
			int op = key.nextInt();
			if(op == 5) {
				System.out.println("프로그램 종료!");
				break;
			}
			else if (op == 1) {
				System.out.println("덧셈할 데이터1 입력");
				int data1 = key.nextInt();
				System.out.println("덧셈할 데이터2 입력");
				int data2 = key.nextInt();
				System.out.println("결과 : "+ data1 + " + " + data2 + " = " + (data1 + data2));
			}
			else if (op == 2) {
				System.out.println("뺄셈할 데이터1 입력");
				int data1 = key.nextInt();
				System.out.println("뺄셈할 데이터2 입력");
				int data2 = key.nextInt();
				System.out.println("결과 : "+ data1 + " - " + data2 + " = " + (data1 - data2));
			}
			else if (op == 3) {
				System.out.println("곱셈할 데이터1 입력");
				int data1 = key.nextInt();
				System.out.println("곱셈할 데이터2 입력");
				int data2 = key.nextInt();
				System.out.println("결과 : "+ data1 + " * " + data2 + " = " + (data1 * data2));
			}
			else if (op == 4) {
				System.out.println("나눗셈할 데이터1 입력");
				int data1 = key.nextInt();
				System.out.println("나눗셈할 데이터2 입력");
				int data2 = key.nextInt();
				System.out.println("결과 : " + data1 + " / " + data2 + " = " + (data1 / data2));
			}
			else if(op != 1 || op != 2 ||op != 3 ||op != 4 ||op != 5) {
				System.out.println("1~5 사이의 값을 입력해야 프로그램 작동해유~");
			}
			
		}
	}

}
