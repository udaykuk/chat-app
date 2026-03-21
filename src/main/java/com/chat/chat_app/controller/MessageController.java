package com.chat.chat_app.controller;

import com.chat.chat_app.entity.Message;
import com.chat.chat_app.entity.User;
import com.chat.chat_app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @MessageMapping("/chat/{id}")
    @SendTo("/topic/chatroom/{id}")
    public Message sendGroupMessage(@DestinationVariable Long id, Message message) {
        return messageService.sendGroupMessage(message.getSender().getId(), id, message.getContent());
    }

    @MessageMapping("/private/{receiverId}")
    @SendToUser("/topic/private")
    public Message sendPrivateMessage(@DestinationVariable Long receiverId, Message message){
        return messageService.sendMessage(message.getSender().getId(), receiverId, message.getContent());
    }

    @MessageMapping("/read/{messageId}")
    @SendTo("/topic/read/{messageId}")
    public List<User> markAsRead(@DestinationVariable Long messageId, Message message){
        return messageService.ReadBy(messageId, message.getSender().getId());
    }
}
