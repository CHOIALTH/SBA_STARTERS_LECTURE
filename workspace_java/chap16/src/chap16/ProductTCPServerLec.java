package chap16;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ProductTCPServerLec {

	public static void main(String[] args) throws Exception {// Exception 전체를 throws!
		// 파일형태로 저장 하기 위함.
		ServerSocket ss = new ServerSocket(10000);
		System.out.println("[==서버는 10000번 port에서 대기중 입니다.==]");
		int count = 0;
		while(true) {
			Socket s = ss.accept();
			String clientIP = s.getInetAddress().getHostAddress();
			System.out.println("[==서버는 클라이언트(" + clientIP + ") 접속을 허용합니다.==]");
			count++;
			if(count == 4) {break;} //3개까지는 넣고 4개부터 break 걸려야!
			FileWriter fw = new FileWriter("product.txt", true);

			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String name = sc.next();	
			String price = sc.next();	
			String inven = sc.next();	
			// 클라이언트가 보낸 3개의 정보 = 입력스트림(InputStream)
			fw.write(name + "-" + price + "-" + inven + "\n");
			// 원하는 형식을 주면서 파일에 3개의 정보를 기록한다.
			fw.close();
			
			String response = "상품 정보 추가 완료!\n";
			OutputStream os = s.getOutputStream();
			byte[] by = response.getBytes();
			os.write(by);
			System.out.println("[==서버는 클라이언트로 정보를 전달합니다.==]");
			// 이상 클라이언트에 대한 처리 응답 = 출력스트림(OutputStream)
			
			os.close();	
			sc.close();
			is.close();
			s.close();
			ss.close();
			// 차례대로 전부 닫자.
			System.out.println("[==서버는 클라이언트 접속을 해제합니다.==]");
			
			// 서버 시작 -> 클라이언트 시작
			// 서버 시작하자마자 product.txt 생성됨
		}		
	}

}
