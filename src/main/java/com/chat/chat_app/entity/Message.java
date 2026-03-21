package com.chat.chat_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name ="receiver_id")
    private User receiver;
    @ManyToOne
    @JoinColumn(name ="Chat_room_id")
    private ChatRoom chatRoom;
    private Date timeStamp;
    @JsonIgnore
    @ManyToMany
    private List<User> readBy;
    private String content;

}
