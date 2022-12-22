package chap16;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientTest {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("1x6.xx.1.20", 10000);	
		String serverIP = s.getInetAddress().getHostAddress();
		// 클라이언트 ServerSocket은 2가지 정보가 요구됨
		System.out.println("==클라이언트가 서버("+ serverIP + ")로 접속했습니다.==");
		
		OutputStream os = s.getOutputStream(); 
		String request = "1번 게시물\n";
		byte by[] =request.getBytes(); os.write(by);
		os.write(by);
		
		InputStream is = s.getInputStream();

		Scanner sc = new Scanner(is);
		String response = sc.nextLine();
		System.out.println("[==서버는 클라이언트로부터" + response +  " 요청을 전달 받았습니다.==]");
		// 이상 서버로부터 응답 받음 = 입력스트림
		
		s.close();
		System.out.println("==클라이언트가 서버의 접속을 해제했습니다.==");
		
	}
}
