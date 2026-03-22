package com.chat.chat_app.service;

import com.chat.chat_app.entity.ChatRoom;
import com.chat.chat_app.entity.Message;
import com.chat.chat_app.entity.User;
import com.chat.chat_app.repository.ChatRoomRepository;
import com.chat.chat_app.repository.MessageRepository;
import com.chat.chat_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.MessagingAdviceBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    ChatRoomRepository chatRoomRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    public Message sendMessage(long senderid,long recieverid ,String content){
        Message message1=new Message();
        message1.setSender(userRepository.getReferenceById(senderid));
        message1.setReceiver(userRepository.getReferenceById(recieverid));
        message1.setContent(content);
        message1.setTimeStamp(new Date());
        messageRepository.save(message1);
        return message1;
    }
    public Message sendGroupMessage(long senderid,long chatroomId ,String content){
        Message message1=new Message();
        message1.setSender(userRepository.getReferenceById(senderid));
        ChatRoom chatRoom = chatRoomRepository.findById(chatroomId)
                .orElseThrow(() -> new RuntimeException("ChatRoom not found"));

        message1.setChatRoom(chatRoom);
        message1.setContent(content);
        message1.setTimeStamp(new Date());
        messageRepository.save(message1);
        return message1;
    }
    public List<Message> getMessagesByChatRoom(long chatRoomId){
        ChatRoom chatRoom=chatRoomRepository.getReferenceById(chatRoomId);
        List<Message> messages=messageRepository.findByChatRoom(chatRoom);
       return messages;
    }
    public List<Message> getPrivateMessages(long senderId, long receiverId){
        User sender=userRepository.getReferenceById(senderId);
        User receiver=userRepository.getReferenceById(receiverId);
        List<Message> messages=messageRepository.findBySenderAndReceiver(sender,receiver);
        return messages;
    }
    public List<User> ReadBy(long messageId,long userId){
        Message message=messageRepository.getReferenceById(messageId);
        User user =userRepository.getReferenceById(userId);
        List<User> readBy = message.getReadBy();
        readBy.add(user);
        message.setReadBy(readBy);
        messageRepository.save(message);
        return readBy;
    }
}
