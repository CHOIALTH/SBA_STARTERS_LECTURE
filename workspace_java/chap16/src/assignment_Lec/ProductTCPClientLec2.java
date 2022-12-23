package assignment_Lec;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPClientLec2 {

	public static void main(String[] args) throws Exception {
		System.out.println("상품 정보를 입력하세요");
		Scanner key = new Scanner(System.in);
		System.out.println("상품명 : ");
		String name = key.next();
		System.out.println("가격 : ");
		System.out.println("재고량 : ");
		
		Socket s = new Socket("176.16.1.20", 10000);
		String serverIP = s.getInetAddress().getHostAddress();

		System.out.println("==클라이언트가 서버("+ serverIP + ")로 접속했습니다.==");
		
		OutputStream os = s.getOutputStream(); 

		name = name + " "; // 정보별 구분 목적으로 공백을 붙임. ex ) name price inven 형태로 담긴다

		os.write(name.getBytes());

		// 3개의 정보를 따로 보낸다.
		// 이상 클라이언트 -> 서버 정보 전송
		
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		String response = sc.nextLine();
		System.out.println("[==서버는 클라이언트로부터" + response +  " 요청을 전달 받았습니다.==]");
		
		// 이상 서버로부터 응답("추가완료~") -> 입력스트림 
		sc.close();
		s.close();
		key.close();
		System.out.println("==클라이언트가 서버의 접속을 해제했습니다.==");
		
	}
}
