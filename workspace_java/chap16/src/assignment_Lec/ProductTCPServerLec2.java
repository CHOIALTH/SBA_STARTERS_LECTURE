package assignment_Lec;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductTCPServerLec2 {
	static ArrayList getProductList(String filename)throws IOException { // public 생략 가능하여 생략함
		FileReader fr = new FileReader(filename);
		Scanner sc2 =new Scanner(fr);
		// BufferedReader 사용해도됨
		ArrayList<String> list = new ArrayList<String>(3);
		while(sc2.hasNextLine()) {
			 list.add(sc2.nextLine());
		}
		fr.close();
		System.out.println(list.size()); // 3을 리턴
		return list;
	}
	public static void main(String[] args) throws Exception {// product.txt 내용을 입력하여 ArrayList 형태로 리턴
		ArrayList<String> list = getProductList("product.txt");
		ServerSocket ss = new ServerSocket(10000);
		System.out.println("[==서버는 10000번 port에서 대기중 입니다.==]");
		int count = 0;
		while(true) {
			Socket s = ss.accept();
			String clientIP = s.getInetAddress().getHostAddress();
			System.out.println("[==서버는 클라이언트(" + clientIP + ") 접속을 허용합니다.==]");
			count++;
			if(count == 4) {break;} //3개까지는 넣고 4개부터 break 걸려야!

			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);
			String name = sc.next();	
			//String price = sc.next();	
			//String inven = sc.next();	
			// 클라이언트가 보낸 3개의 정보 = 입력스트림(InputStream)
			String response = null;
			for(String product : list) {
				String pName = product.split(" -")[0];
				// split시 공백 뒤로 주면 무시되므로 앞으로 줘야
				if(pName.equals(name)) {
					response = product;
				}
			}
			if(response == null) {
				response = "못찾았습니다";
			} 
			
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
