package chap16;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductTCPClient {
	// 1. 키보드 입력 ( 상품 추가, 상품명, 가격, 재고량)
	// 2. 서버로 전송
	// 5. 서버로부터 추가여부 결과 출력
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("176.16.1.20", 3000);
		System.out.println("상품추가를 위한 입력");
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("상품명 : ");
		arr.add("가격 : ");
		arr.add("재고량 : ");
		arr.add("종료하기");
		System.out.println("상품추가를 시작합니다.\n종료하려면 4 또는 q를 입력하세요\n");
		for(int i = 0; i < arr.size(); i++) {
			System.out.println((i+1) + ". " + arr.get(i));
		} // for end
		while(true) {
			Scanner key = new Scanner(System.in);
			String num = key.next();
			if(num.equals("4")||num.equals("q")) {
				System.out.println("종료!");
				System.exit(0);
			}
			else {
				String name = key.next();
				String price = key.next();
				String inven = key.next();
			}
		}
		
	}

}
