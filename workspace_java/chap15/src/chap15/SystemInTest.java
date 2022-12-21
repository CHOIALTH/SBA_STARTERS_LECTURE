package chap15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class SystemInTest {

	public static void main(String[] args) throws IOException {
		System.out.println("키보드 입력을 대기중입니다.");
		/*
		 * while (true) { // while문의 조건에 true만 주면, 무한루프 역할(강제적으로 종료하지 않으면 계속 돈다) int
		 * data = System.in.read(); // if(data == 'q') break;
		 * System.out.println((char)data); }
		 */
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		/*
		 * while(true) { int data = isr.read(); if(data == '큐') break;
		 * System.out.println((char)data); }
		 */
		/*
		 * while(true) { String data = br.readLine(); if(data.equals("q")) break;
		 * System.out.println(data); }
		 */
		Scanner key = new Scanner(System.in);
		while(key.hasNextInt()) {
			int first = key.nextInt();
			int second = key.nextInt();
			System.out.println(first + second);
		}
		//while(key.hasNext()) {// 공백 이전 문자열
		//	String first = key.nextLine();
		//	System.out.println(first);
		//}
	}

}
