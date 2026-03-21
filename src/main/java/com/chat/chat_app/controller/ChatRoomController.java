package com.chat.chat_app.controller;

import com.chat.chat_app.entity.ChatRoom;
import com.chat.chat_app.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatrooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom, @RequestParam List<Long> memberIds) {
        return chatRoomService.createChatRoom(chatRoom.getName(), chatRoom.getDescription(), memberIds);
    }

    @GetMapping
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomService.getChatRooms();
    }

    @GetMapping("/{id}")
    public ChatRoom getChatRoomById(@PathVariable long id) {
        return chatRoomService.getChatRoomById(id);
    }

    @PostMapping("/{id}/add")
    public ChatRoom addMember(@PathVariable long id, @RequestParam String username) {
        return chatRoomService.addMember(id, username);
    }

    @DeleteMapping("/{id}/leave")
    public ChatRoom leaveGroup(@PathVariable long id, @RequestParam String username) {
        return chatRoomService.leaveMember(id, username);
    }
}