package mc.sn.waw;

import mc.sn.waw.ChatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

	
	
    private Map<String, ChatRoom> chatRoomMap;
    
    
    
    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom(){
        System.out.println("finding rooms");
    	List chatRooms = new ArrayList<>(chatRoomMap.values());
        System.out.println("created list");
        Collections.reverse(chatRooms);
        System.out.println("Collection reverse");
        return chatRooms;
    }

    public ChatRoom findRoomById(String id){
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(String name){
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}