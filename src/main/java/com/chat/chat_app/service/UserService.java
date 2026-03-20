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
    public User updateOnlineStatus(Long id,Boolean status) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user1.setStatus(status);
        userRepository.save(user1);
        return user1;
    }

}
