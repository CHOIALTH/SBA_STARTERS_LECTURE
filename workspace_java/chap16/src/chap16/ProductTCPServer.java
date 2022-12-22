package chap16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductTCPServer {
	// 3개 클라이언트만 처리
	// 3. 서버 내부 product.txt 파일 내부에 클라이언트가 전송한 상품정보 저장
	// 4. 클라이언트에게 "추가 완료되었습니다" 알려준다
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(3000);
		System.out.println("[==Server : 3000 port waiting==]");
		while (true) {
			Socket s = ss.accept();
		}
	}

}
