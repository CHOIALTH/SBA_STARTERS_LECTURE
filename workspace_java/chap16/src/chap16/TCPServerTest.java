package chap16;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerTest {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10000);
		// 몇번 port를 사용할 지 정보를 담고 있어야 한다.
		System.out.println("[==서버는 10000번 port에서 대기중 입니다.==]");
		while(true) {
			// 무한루프 돌림
			Socket s = ss.accept();
			String clientIP = s.getInetAddress().getHostAddress();
			// 나랑 연결하고있는 Client IP주소 가져옴.
			//system.out.println("[서버는 클라이언트 접속을 허용합니다]");
			System.out.println("[==서버는 클라이언트(" + clientIP + ") 접속을 허용합니다.==]");
			InputStream is = s.getInputStream();
			//BufferedReader br = new BufferedReader(new InputStreamReader(is));
			//String request = "1번 게시물";
			// 이상 방법1
			Scanner sc = new Scanner(is);
			String request = sc.nextLine();
			String response = "1번 제목1 내용1 작성자1\n";
			OutputStream os = s.getOutputStream();
			byte[] by = response.getBytes();
			os.write(by);
			System.out.println("[==서버는 클라이언트로부터" + request +  " 요청을 전달 받았습니다.==]");
			// 이상 입력 처리
			s.close();
			// System.out.println("[서버는 클라이언트 접속을 해제합니다]");
			System.out.println("[==서버는 클라이언트 접속을 해제합니다.==]");
		}		
	}

}
