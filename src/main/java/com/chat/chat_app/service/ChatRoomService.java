package com.chat.chat_app.service;

import com.chat.chat_app.entity.ChatRoom;
import com.chat.chat_app.entity.User;
import com.chat.chat_app.repository.ChatRoomRepository;
import com.chat.chat_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ChatRoomService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChatRoomRepository chatRoomRepository;

    public ChatRoom createChatRoom(String name, String description, List<Long> memberId){
        ChatRoom chatRoom=new ChatRoom();
        if(memberId.size()<2)
            throw new RuntimeException("Group must have at least 2 members!");
        else{chatRoom.setName(name);
            chatRoom.setDescription(description);
            chatRoom.setCreatedAt(new Date());
            List<User> member= userRepository.findAllById(memberId);
            chatRoom.setMembers(member);
            chatRoomRepository.save(chatRoom);

        }
        return chatRoom;
    }
    public ChatRoom addMember(long chatRoomId,String username){
        ChatRoom chatRoom=chatRoomRepository.getReferenceById(chatRoomId);
        List<User> list=chatRoom.getMembers();
        list.add(userRepository.findByUsername(username));
         chatRoom.setMembers(list);
         chatRoomRepository.save(chatRoom);
        return chatRoom;
    }
    public ChatRoom leaveMember(long ChatRoomId,String username){
        ChatRoom chatRoom=chatRoomRepository.getReferenceById(ChatRoomId);
        List<User> list=chatRoom.getMembers();
        list.remove(userRepository.findByUsername(username));
        chatRoom.setMembers(list);
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }
    public List<ChatRoom> getChatRooms(){
        return chatRoomRepository.findAll();
    }
    public ChatRoom getChatRoomById(long id){
        return chatRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChatRoom not found!"));
    }

}
