package chap16;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSender {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(); // 랜덤포트
		System.out.println("[발신자 : 발신 시작!]");
		String data = "지금 몇시에여?";
		// String data = "오늘 오후 5시 반에 수업을 종료합니다";
		byte by[] = data.getBytes();

		DatagramPacket dp = new DatagramPacket(by, by.length, new InetSocketAddress("176.16.1.20", 15000));
		ds.send(dp);
		System.out.println("[발신자 : 발신 처리!]");
		// by 배열의 ~byte 만큼 보낸다! (길이지정 꼭 해줘야)
		// new InetSocketAddress("전송받을 상대방 ip주소", 포트번호)
		System.out.println("[발신자 : 발신 종료!]");

		byte b[] = new byte[100];
		DatagramPacket receiveDp = new DatagramPacket(b, b.length);
		ds.receive(receiveDp);
		String s = new String();
		ds.close();
	}
}
