package assignment;

import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		System.out.println("키보드입력");
		Scanner key = new Scanner(System.in);
		System.out.println("이름 :");
		String name = key.next();
		System.out.println("국어 :");
		String kor = key.next();
		System.out.println("수학 :");
		String math = key.next();
		System.out.println("영어 :");
		String eng = key.next();
		System.out.println("총점 :");
		String sum = key.next();
		System.out.println("평균 :");
		String avg = key.next();
	}
}
