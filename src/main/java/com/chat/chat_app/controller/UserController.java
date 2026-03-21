package com.chat.chat_app.controller;

import com.chat.chat_app.entity.User;
import com.chat.chat_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chat")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User createAccount(@RequestBody User user ){
    User user1=userService.createuser(user.getUsername(),user.getProfilePicture());
    return user1;
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username){
        User user=userService.getUserByUsername(username);
        return user;
    }
    @GetMapping("/AllOnline")
    public List<User> GetAllOnline(){
        return userService.getAllOnlineUsers();
    }
    @PutMapping("/{id}")
    public User updateOnlineStatus(@PathVariable long id,@RequestBody boolean status){
        return userService.updateOnlineStatus(id,status);
    }

}
