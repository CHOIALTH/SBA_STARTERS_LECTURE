package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
//여러개 웹소켓 클라이언트 공유- 

@Component
public class ChatWebSocketHandler implements WebSocketHandler{
	
	public static List<WebSocketSession> list = new ArrayList();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		//session - 웹소켓 클라이언트객체 1개
		//message- 웹소켓 클라이언트가 보낸 문자열데이터 - nickname:xxxxxx
		String msg = (String)message.getPayload();
		for(WebSocketSession s : list) {
			WebSocketMessage<String> sendmsg = new TextMessage(msg);
			s.sendMessage(sendmsg);
		}
		
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		list.remove(session);
		
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	
}
