package chap16;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPReceiver {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(15000); 
		// 받아야하는 쪽에서 15000번의 포트를 지정함
		System.out.println("[수신자 : 수신 시작!]");
		
		/*
		 * String data = "오늘 오후 5시 반에 수업을 종료합니다";
		 * byte by[] = data.getBytes(); 
		 * DatagramPacket dp = new DatagramPacket(by, by.length, new
		 * InetSocketAddress("176.16.1.20",15000)); ds.send(dp);
		 * System.out.println("[수신자 : 수신 처리!]"); // by 배열의 ~byte 만큼 보낸다! (길이지정 꼭 해줘야) //
		 * new InetSocketAddress("전송받을 상대방 ip주소", 포트번호)
		 */	
		byte b[] = new byte[1000];
		// 수신받은 내용 저장 배열
		DatagramPacket dp = new DatagramPacket(b, b.length);
		ds.receive(dp);
		
		String s = new String(b);
		// 배열 b -> String 형변환
		
		System.out.println(dp.getAddress() + " 주소의 " +dp.getPort() + "포트에서 " + s.trim() + " 받았습니다.");
		// 여기서 s는 'dp.getData() = b'를 String으로 형변환한것
		// 한글 영문 순자 --> 1문자당 2byte
		// getBytes() --> 영문 숫자 특수문자 : 1문자당 1byte / 한글 등 다국어 : 1문자당 3byte
		// .trim() --> 문자열에 붙는 쓸모없는 박스 같은거 없애주는 메서드
		
		String theTime = new SimpleDateFormat("HH시 mm분 ss초").format(new Date());
		DatagramPacket timeDp = new DatagramPacket(theTime.getBytes(),theTime.getBytes().length, dp.getAddress(), dp.getPort());
		// 몇시나는 질문에 대한 응답!
		ds.send(timeDp);
		ds.close(); 
		System.out.println("[수신자 : 수신 종료!]");
	}
}
