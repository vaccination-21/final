package mc.sn.waw;

public class ChatMessage {
    private String chatRoomId;
    private String writer;
	private String message;
    private MessageType type;
    
    public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}



	public String getChatRoomId() {
		// TODO Auto-generated method stub
		return chatRoomId;
	}

}
