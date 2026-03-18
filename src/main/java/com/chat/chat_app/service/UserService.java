package com.chat.chat_app.service;

import com.chat.chat_app.entity.User;
import com.chat.chat_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createuser( String username,String profilePicture){
        User user= new User();
        user.setUsername(username);
        user.setProfilePicture(profilePicture);
        userRepository.save(user);
    return user;
    }
    public User getUserByUsername(String username){
        User user= userRepository.findByUsername(username);
         return user;
    }
    public List<User> getAllOnlineUsers(){
        return userRepository.findByStatusTrue();
    }
    public User updateOnlineStatus(String username,User user) {
        User user1 = getUserByUsername(username);
        if(user1.isStatus()==true)
            user1.setStatus(true);
        userRepository.save(user1);
        return user1;
    }
}
