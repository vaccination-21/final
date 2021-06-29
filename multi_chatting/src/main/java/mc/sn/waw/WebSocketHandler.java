package mc.sn.waw;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler {
	private ChatRoomRepository chatRoomRepository;
	private ObjectMapper objectMapper;
	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		String msg = message.getPayload();
		ChatMessage chatMessage = objectMapper.readValue(msg, ChatMessage.class);
		ChatRoom chatRoom = chatRoomRepository.findRoomById(chatMessage.getChatRoomId());
		chatRoom.handleMessage(session,chatMessage, objectMapper);
	}
}
