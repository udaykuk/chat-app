package com.chat.chat_app.repository;

import com.chat.chat_app.entity.ChatRoom;
import com.chat.chat_app.entity.Message;
import com.chat.chat_app.entity.User;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByChatRoom(ChatRoom chatRoom);
    List<Message> findBySenderAndReceiver(User sender, User receiver);


}
