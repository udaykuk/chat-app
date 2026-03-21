package com.chat.chat_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String profilePicture;
    private boolean status;
    private Date lastSeen;
    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    private List<ChatRoom>chatRooms;


}
